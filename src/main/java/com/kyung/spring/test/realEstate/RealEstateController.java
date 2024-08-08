package com.kyung.spring.test.realEstate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kyung.spring.test.realEstate.domain.RealEstate;
import com.kyung.spring.test.realEstate.service.RealEstateService;

@Controller
public class RealEstateController {
	
	@Autowired
	private RealEstateService realEstateService;
	
	@RequestMapping("/mybatis/real-estate/1")
	@ResponseBody
	public RealEstate realEstate(@RequestParam("id") int id) {
		RealEstate realEstate = realEstateService.getRealEstate(id);
		
		return realEstate;
	}
	
	@RequestMapping("/mybatis/real-estate/2")
	@ResponseBody
	public List<RealEstate> realEstateRent(@RequestParam("rent") int rent) {
		List<RealEstate> realEstateRent = realEstateService.getRealEstateRent(rent);
		
		return realEstateRent;
	}
	
	@RequestMapping("/mybatis/real-estate/3")
	@ResponseBody
	//AP : AreaPrice
	public List<RealEstate> realEstateAP(@RequestParam("area") int area, @RequestParam("price") int price){
		List<RealEstate> realEstateAP = realEstateService.getRealEstateAP(area, price);
		
		return realEstateAP;
	}
}
