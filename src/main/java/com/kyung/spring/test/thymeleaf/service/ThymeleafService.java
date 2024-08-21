package com.kyung.spring.test.thymeleaf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyung.spring.test.thymeleaf.domain.Weather;
import com.kyung.spring.test.thymeleaf.repository.ThymeleafRepository;

@Service
public class ThymeleafService {
	
	@Autowired
	private ThymeleafRepository thymeleafRepository;
	
	public List<Weather> getthymeleafService() {
		
		List<Weather> weatherData = thymeleafRepository.selectThymeleafResponse();
		
		return weatherData;
	}
	
	public int setWeatherService(Weather weather){
		
		int count = thymeleafRepository.InsertWeatherResponse(weather);
		
		return count;
	}
}
