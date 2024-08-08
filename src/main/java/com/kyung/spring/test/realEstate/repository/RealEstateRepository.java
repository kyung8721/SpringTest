package com.kyung.spring.test.realEstate.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kyung.spring.test.realEstate.domain.RealEstate;
@Mapper
public interface RealEstateRepository {
	public RealEstate selectRealEstate(@Param("id")int id);
	
	public List<RealEstate> selectRealEstateRent(@Param("rent") int rent);
	
	public List<RealEstate> selectRealEstateAP(@Param("area")int area, @Param("price")int price);
	
}
