package com.kyung.spring.test.thymeleaf.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kyung.spring.test.thymeleaf.domain.Weather;

@Mapper
public interface ThymeleafRepository {
	public List<Weather> selectThymeleafResponse();
	
	public int InsertWeatherResponse(Weather weather);
}
