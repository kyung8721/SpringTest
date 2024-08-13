package com.kyung.spring.test.seller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.kyung.spring.test.seller.domain.Seller;
import com.kyung.spring.test.seller.service.SellerService;

@RestController
@RequestMapping("/mvc/seller")
public class SellerController {
	
	// 서비스 객체 생성
	@Autowired
	private SellerService sellerService;
	
	// 입력 폼 생성
	@GetMapping("/input")
	public ModelAndView sellerInput() {
		// RestController 사용 시 뷰로 이동하는 법
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("sellerList/sellerInsert");
		return modelAndView;
	}
	
	// 입력된 값 추가하고 추가 결과 출력
	@RequestMapping("/insertSuccess")
	@ResponseBody
	public String sellerInsertSuccess( 
			@RequestParam("nickname") String nickname
			, @RequestParam("profileImage") String profileImage
			, @RequestParam("temperature") float temperature) {
		
		// insert
		// 객체에 파라미터 넣기
		// 객체 생성
		Seller seller = new Seller();
		// 객체에 값 전달
		seller.setNickname(nickname);
		seller.setProfileImage(profileImage);
		seller.setTemperature(temperature);
		
		// service로 전달
		int count = sellerService.sellerInsertService(seller);
		
		return "수정성공 : " + count;
		
	}
	
	// 마지막 추가된 seller 조회
	@GetMapping("/info")
	public ModelAndView sellerInfo(Model model) {
		// 값을 저장할 객체 생성
		Seller seller = sellerService.getLastseller();
		
		// 모델에 값 전달
		model.addAttribute("seller", seller);
		
		// 뷰로 이동
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("sellerList/sellerInfo");
		
		return modelAndView;
	}
	
	// id를 파라미터로 받아서 화면에 표시
	@GetMapping("/inquire")
	public ModelAndView sellerInquire(Model model, @RequestParam(value = "id", required = false)Integer id) {
		// int로는 null 체크가 안되서 Integer로 타입을 잡아줌
		if(id == null) {
			// 파라미터 없을 때 값을 저장할 객체 생성 - 마지막에 저장한 seller가 나오게
			Seller seller = sellerService.getLastseller();
			
			// 모델로 html에 값 전달
			model.addAttribute("seller", seller);
		} else {
			// 파라미터 있을 때 객체 생성
			Seller seller = sellerService.getSeller(id);
			
			// 모델로 html에 값 전달
			model.addAttribute("seller", seller);
		}
		
		// 뷰로 이동
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("sellerList/sellerInfo");

		return modelAndView;
	}
	
}
