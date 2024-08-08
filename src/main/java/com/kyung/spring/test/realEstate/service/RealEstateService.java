package com.kyung.spring.test.realEstate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyung.spring.test.realEstate.domain.RealEstate;
import com.kyung.spring.test.realEstate.repository.RealEstateRepository;

@Service
public class RealEstateService {
	
	@Autowired
	private RealEstateRepository realEstateRepository;
	
	
	// 요청된 행 불러오기
	public RealEstate getRealEstate(int id) {
		RealEstate realEstate = realEstateRepository.selectRealEstate(id);
		
		return realEstate;
	}
	
	public List<RealEstate> getRealEstateRent(int rent){
		List<RealEstate> realEstateRent = realEstateRepository.selectRealEstateRent(rent);
		
		return realEstateRent;
	}
	
	public List<RealEstate> getRealEstateAP(int area, int price){
		List<RealEstate> realEstateAP = realEstateRepository.selectRealEstateAP(area, price);
		
		return realEstateAP;
	}
}
