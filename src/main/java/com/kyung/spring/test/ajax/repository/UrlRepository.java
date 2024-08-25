package com.kyung.spring.test.ajax.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kyung.spring.test.ajax.domain.Url;

@Mapper
public interface UrlRepository {
	public List<Url> urlInfoRepository();
	
	public int urlInsertRepository(Url url);
	
	public int urlDuplicateRepository(String url);
	
	public int urlDeleteRepository(@Param("id") int id);
}
