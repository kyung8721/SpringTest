package com.kyung.spring.test.realtor.repository;

import org.apache.ibatis.annotations.Mapper;

import com.kyung.spring.test.realtor.domain.Realtor;

@Mapper
public interface RealtorRepository {
	public int realtorInsertRepository(Realtor realtor);
}
