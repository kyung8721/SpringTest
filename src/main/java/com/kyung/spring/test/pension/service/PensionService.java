package com.kyung.spring.test.pension.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyung.spring.test.pension.domain.Booking;
import com.kyung.spring.test.pension.repository.PensionRepository;

@Service
public class PensionService {
	
	// repository 객체 생성
	@Autowired
	private PensionRepository pensionRepository;
	
	public List<Booking> pensionListService(){
		
		List<Booking> booking = new ArrayList<>();
		
		booking = pensionRepository.pensionListRepository();
		
		return booking;	
	}
	
	public int bookingDeleteService(int id){
		int count = pensionRepository.bookingDeleteRepository(id);
		
		return count;
	}
	
	public int bookingInsertService(Booking booking){
		int count = pensionRepository.bookingInsertRepository(booking);
		
		return count;
	}
	
	public Booking bookingCheckService(String name, String PH){
		Booking booking = new Booking();
		
		booking = pensionRepository.bookingCheckRepository(name, PH);
		
		return booking;
	}
}

