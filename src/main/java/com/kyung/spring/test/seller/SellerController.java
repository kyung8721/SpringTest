package com.kyung.spring.test.seller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kyung.spring.test.seller.domain.Seller;
import com.kyung.spring.test.seller.service.SellerService;

@Controller
public class SellerController {
	
	// 서비스 객체 생성
	@Autowired
	private SellerService sellerService;
	
	// 입력 폼 생성
	@GetMapping("/mvc/seller/input")
	public ModelAndView sellerInput() {
		// RestController 사용 시 뷰로 이동하는 법
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("sellerList/sellerInsert");
		return modelAndView;
	}
	
	// 입력된 값 추가하고 추가 결과 출력
	// 데이터 저장 기능
	@PostMapping("/mvc/seller/insertSuccess")
	public String sellerInsertSuccess(RedirectAttributes redirectAttributes
			, @RequestParam("nickname") String nickname
			, @RequestParam("profileImage") String profileImage
			, @RequestParam("temperature") double temperature) {
		
		// insert
		// 객체에 파라미터 넣기
		// 객체 생성
		Seller seller = new Seller();
		// 객체에 값 전달
		seller.setNickname(nickname);
		seller.setProfileImage(profileImage);
		seller.setTemperature(temperature);
		
		// service로 전달
		sellerService.sellerInsertService(seller);
		
		// id 받아오기
		//int id = seller.getId(); // 어차피 최신거니까 id는 안써도 됨
		
		
		// 파라미터 저장
		redirectAttributes.addAttribute("stringAdd", "추가되었습니다!"); // 화면 제일 위에 보여줄 문구

		return "redirect:/mvc/seller/inquire";
		
	}
	
	
	// id를 파라미터로 받아서 화면에 표시
	@GetMapping("/mvc/seller/inquire")
	public ModelAndView sellerInquire(Model model, @RequestParam(value = "id", required = false)Integer id
			, @RequestParam(value = "stringAdd", required = false)String stringAdd) {
		// @RequestParam(value = "id", required = false) : 파라미터가 안 들어올 경우를 대비
		// int로는 null 체크가 안되서 Integer로 타입을 잡아줌
		
		// 객체 미리 생성
		Seller seller = null;
		
		if(id == null) { // 파라미터 없음
			// 값을 저장할 객체 생성 - 마지막에 저장한 seller가 나오게
			seller = sellerService.getLastseller();
			
			// 모델로 html에 값 전달
			model.addAttribute("seller", seller);
			
		} else { // 파라미터(id) 전달 있음
			//  객체 생성
			seller = sellerService.getSeller(id);
			
			// 모델로 html에 값 전달
			model.addAttribute("seller", seller);
		}
		
		if(stringAdd != null) { // stringAdd가 있으면 문구 추가
			model.addAttribute("add", stringAdd);
		}
		
		// 뷰로 이동
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("sellerList/sellerInfo");

		return modelAndView;
	}
	
}
