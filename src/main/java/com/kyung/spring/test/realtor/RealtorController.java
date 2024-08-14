package com.kyung.spring.test.realtor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kyung.spring.test.realtor.domain.Realtor;
import com.kyung.spring.test.realtor.service.RealtorService;

@Controller
@RequestMapping("/mvc/realtor")
public class RealtorController {
	
	// 서비스 객체
	@Autowired
	private RealtorService realtorService;
	
	// 입력 폼으로 이동
	@RequestMapping("/input")
	public String realtorInput() {
		return "realtor/realtorInput";
	}
	
	// 입력된 값 받아와서 DB에 추가
	@RequestMapping("/insert")
	public String realtorInsert(Model model
			, @RequestParam("office") String office
			, @RequestParam("phoneNumber") String PH
			, @RequestParam("address") String address
			, @RequestParam("grade") String grade) {
		// 객체 생성
		Realtor realtor = new Realtor();
		// 객체에 값 집어 넣기
		realtor.setOffice(office);
		realtor.setPhoneNumber(PH);
		realtor.setAddress(address);
		realtor.setGrade(grade);
		
		// 객체를 서비스로 전달
		realtorService.realtorInsertService(realtor);
		
		// id 가져오기
		// int id = realtor.getId();
		
		// id 가져오고 나서 모델에 객체 추가
		model.addAttribute("realtor", realtor);
		
		// 뷰로 리턴
		return "realtor/realtorInfo";
	}
	
	// 확인용
//	@RequestMapping("/check")
//	public String Check() {
//		return "realtor/realtorInfo";
//	}
//	
//	// 확인용2
//	@RequestMapping("/check2")
//	public String Check2(Model model) {
//		
//		Realtor realtor = new Realtor();
//		realtor.setId(1);
//		realtor.setOffice("office");
//		realtor.setPhoneNumber("PH");
//		realtor.setAddress("address");
//		realtor.setGrade("grade");
//		
//		model.addAttribute("realtor", realtor);
//		return "realtor/realtorInfo";
//	}
}
