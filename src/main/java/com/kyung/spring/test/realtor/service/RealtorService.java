package com.kyung.spring.test.realtor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyung.spring.test.realtor.domain.Realtor;
import com.kyung.spring.test.realtor.repository.RealtorRepository;

@Service
public class RealtorService {
	@Autowired
	private RealtorRepository realtorRepository;
	
	public int realtorInsertService(Realtor realtor) {
		int count = realtorRepository.realtorInsertRepository(realtor);
		return count;
	}
}
