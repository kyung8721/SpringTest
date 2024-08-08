package com.kyung.spring.test.Store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyung.spring.test.Store.domain.Store;
import com.kyung.spring.test.Store.repository.StoreRepository;

@Service
public class StoreService {
	
	// repository의 객체 관리 스프링에 위임
	@Autowired
	private StoreRepository storeRepository;
	
	public List<Store> getStoreList(){
		List<Store> storeList = storeRepository.selectStoreList();
		
		return storeList;
	}
}
