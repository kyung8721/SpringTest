package com.kyung.spring.test.realEstate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kyung.spring.test.realEstate.domain.RealEstate;
import com.kyung.spring.test.realEstate.service.RealEstateService;

@RestController
@RequestMapping("/mybatis/real-estate")
public class RealEstateController {
	
	@Autowired
	private RealEstateService realEstateService;
	
	@RequestMapping("/1")
	@ResponseBody
	public RealEstate realEstate(@RequestParam("id") int id) {
		RealEstate realEstate = realEstateService.getRealEstate(id);
		
		return realEstate;
	}
	
	@RequestMapping("/2")
	@ResponseBody
	public List<RealEstate> realEstateRent(@RequestParam("rent") int rent) {
		List<RealEstate> realEstateRent = realEstateService.getRealEstateRent(rent);
		
		return realEstateRent;
	}
	
	@RequestMapping("/3")
	@ResponseBody
	//AP : AreaPrice
	public List<RealEstate> realEstateAP(
			@RequestParam("area") int area,
			@RequestParam("price") int price){
		List<RealEstate> realEstateAP = realEstateService.getRealEstateAP(area, price);
		
		return realEstateAP;
	}
	
	// 객체로 값을 전달해서 값을 insert
	@RequestMapping("/4")
	@ResponseBody
	public String realEstateInsert() {
		// 전달할 값
//		realtorId : 3
//		address : 푸르지용 리버 303동 1104호
//		area : 89
//		type : 매매
//		price : 100000
		
		//객체 생성
		RealEstate realEstate = new RealEstate();
		
		//객체에 값 전달
		realEstate.setRealtorId(3);
		realEstate.setAddress("푸르지용 리버 303동 1104호");
		realEstate.setArea(89);
		realEstate.setType("매매");
		realEstate.setPrice(100000);
		
		//서비스로 insert 기능 넘기기
		int count = realEstateService.getRealEstateInsert(realEstate);
		
		//값 리턴
		return "입력 성공 : " + count;
	}
	
	// 파라미터로 값을 전달 받아 insert
	// 객체 없이
	@RequestMapping("/5")
	@ResponseBody
	public String realEstateInsertByParameter(@RequestParam("realtorId")int realtorId) {
		// 입력할 값 - realtorId는 파라미터로 전달
//		address : 썅떼빌리버 오피스텔 814호
//		area : 45
//		type : 월세
//		price : 100000
//		rentPrice : 120
		
		// service에 값 전달 - insert를 위함
		int count = realEstateService.getRealEstateInsertByParameter(
				realtorId, "썅떼빌리버 오피스텔 814호", 45, "월세", 100000, 120);
		
		// 화면에 리턴
		return "입력 성공 : " + count;
	}
	
	// Update
	@RequestMapping("/6")
	@ResponseBody
	public String realEstateUpdate(@RequestParam("id") int id, @RequestParam("type") String type, @RequestParam("price") int price) {
//		id가 22 인 행의 type 을 전세로 바꾸고 price 를 70000으로 변경하세요.
		
		// update를 위해 service에 파라미터 전달
		// 객체로
		
		// 객체 생성
		RealEstate realEstate = new RealEstate();
		
		// 객체에 값 전달
		realEstate.setId(id);
		realEstate.setType(type);
		realEstate.setPrice(price);
		
		// service로 객체 전달
		int count = realEstateService.getRealEstateUpdate(realEstate);
		
		// 전달받은 결과를 return
		return "수정 성공 : " + count;
	}
}
