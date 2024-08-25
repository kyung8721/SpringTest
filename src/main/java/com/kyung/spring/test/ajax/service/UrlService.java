package com.kyung.spring.test.ajax.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyung.spring.test.ajax.domain.Url;
import com.kyung.spring.test.ajax.repository.UrlRepository;

@Service
public class UrlService {
	
	// repository 객체 생성
	@Autowired
	private UrlRepository urlRepository;
	
	public List<Url> urlInfoService() {
		
		List<Url> urlList= new ArrayList<>();
		
		urlList = urlRepository.urlInfoRepository();
		
		return urlList;
	}
	
	public int urlInsertService(Url url){
		int count = urlRepository.urlInsertRepository(url);
		return count;
	}
	
	public boolean urlDuplicateService(String url){
		int count = urlRepository.urlDuplicateRepository(url);
		
		if(count == 0) {
			return false; // 중복 안됨
		} else {
			return true; // 중복됨
		}

	}
	
	public int urlDeleteService(int id){
		int count = urlRepository.urlDeleteRepository(id);
		
		return count;
	}
}
