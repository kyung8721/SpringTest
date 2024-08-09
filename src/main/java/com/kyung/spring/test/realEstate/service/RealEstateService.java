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
	
	public List<RealEstate> getRealEstateRent(int rent){ // 하나라고 정해진 경우가 아니면 대부분 List로 받음
		List<RealEstate> realEstateRent = realEstateRepository.selectRealEstateRent(rent);
		
		return realEstateRent;
	}
	
	public List<RealEstate> getRealEstateAP(int area, int price){
		List<RealEstate> realEstateAP = realEstateRepository.selectRealEstateAP(area, price);
		
		return realEstateAP;
	}
	
	//객체로 Insert 값 넘기기
	public int getRealEstateInsert(RealEstate realEstate) {
		// 받은 객체를 insert하는 쿼리 처리는 repository로 넘기기
		int count = realEstateRepository.insertRealEstate(realEstate);
		
		// 받은 값 Controller로 리턴
		return count;
	}
	
	// 객체 없이 insert 값 넘기기
	public int getRealEstateInsertByParameter(
			int realtorId
			, String address
			, int area
			, String type
			, int price
			, int rentPrice) {
		// 쿼리 처리를 위해 repository로 값 전달
		int count = realEstateRepository.insertRealEstateByParameter(
				realtorId, address, area, type, price, rentPrice);
		
		// 쿼리 처리 후 전달받은 값을 controller로 전달
		return count;
				
	}
	
	// 객체로 받은 값을 업데이트
	public int getRealEstateUpdate(RealEstate realEstate) {
		// 쿼리 처리를 위해 객체 형태로 repository에 전달
		int count = realEstateRepository.updateRealEstate(realEstate);
		
		// 전달 받은 값을 controller로 전달
		return count;
	}
}
