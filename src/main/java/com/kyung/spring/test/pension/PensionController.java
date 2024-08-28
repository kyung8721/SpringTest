package com.kyung.spring.test.pension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kyung.spring.test.pension.domain.Booking;
import com.kyung.spring.test.pension.service.PensionService;


@Controller
@RequestMapping("/ajax/pension")
public class PensionController {
	
	// 서비스 객체 생성
	@Autowired
	private PensionService pensionService;
	
	// 메인화면
	@GetMapping("/home")
	public String pensionHome(Model model) {
		
		
		
		return "ajax/pension/pensionHome";
	}
	
	// 리스트 출력 API
	@GetMapping("/list")
	public String pensionList(Model model) {
		
		// 객체에 담기
		Booking booking = new Booking();
		
		// 예약목록 저장할 리스트 생성
		List<Booking> bookingList = new ArrayList<>();
		
		// 예약목록 리스트 불러오기(서비스 호출)
		bookingList = pensionService.pensionListService();
		
		// 받아온 예약목록 리스트 모델에 전달
		model.addAttribute("bookingList", bookingList);
		
		
		
		return "ajax/pension/pensionList";
	}
	
	// 예약 API
	@GetMapping("/book")
	public String pensionBook() {
		return "ajax/pension/pensionBook";
	}
	
	// 리스트 삭제 API
	@GetMapping("/delete")
	@ResponseBody
	public Map<String, String> bookingDelete(
			@RequestParam("id") int id){
		

		int count = pensionService.bookingDeleteService(id);
		
		// {"result" : "success"}
		// {"result" : "false"}
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1) {
			// 삭제 성공
			resultMap.put("result", "success");
		}else{
			// 삭제 실패
			resultMap.put("result", "false");
		}
		
		return resultMap;
	}
	
	// 리스트 추가 API
	@GetMapping("/insert")
	@ResponseBody
	public Map<String, String> pansionInsert(
			@RequestParam("name") String name
			, @RequestParam("date") @DateTimeFormat(pattern="yyyy년 M월 d일") LocalDate date
			, @RequestParam("day") int day
			, @RequestParam("headcount") int headcount
			, @RequestParam("phoneNumber") String phoneNumber
			, @RequestParam("state") String state) {
		
		// Url 객체 생성
		Booking booking = new Booking();
		
		// 객체에 값 추가
		booking.setName(name);
		booking.setDate(date);
		booking.setDay(day);
		booking.setHeadcount(headcount);
		booking.setPhoneNumber(phoneNumber);
		booking.setState(state);
		
		
		int count = pensionService.bookingInsertService(booking);
		
		// json 문자열로 response에 데이터를 채움
		// 성공여부
		// {"result" : "success"}
		// {"result" : "fail"}
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1) {
			// 성공
			resultMap.put("result", "success");
		} else {
			// 실패
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
	// 예약 확인 API
	@GetMapping("/check")
	@ResponseBody
	public Map<String, Object> pensionBookingCheck(
			@RequestParam("name") String name
			, @RequestParam("phoneNumber") String PH) {
		
		Booking booking = new Booking();
		Map<String, Object> resultMap = new HashMap<>();
		
		booking = pensionService.bookingCheckService(name, PH);
		
		if(booking == null) {
			resultMap.put("result", "fail");
		} else {
			resultMap.put("result", "success");
			resultMap.put("booking", booking);
		}
		
		return resultMap;
		
	}
}
