package com.kyung.spring.test.realEstate.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kyung.spring.test.realEstate.domain.RealEstate;
@Mapper
public interface RealEstateRepository {
	public RealEstate selectRealEstate(@Param("id")int id);
	
	public List<RealEstate> selectRealEstateRent(@Param("rent") int rent);
	
	public List<RealEstate> selectRealEstateAP(
			@Param("area")int area,
			@Param("price")int price);
	
	// 객체로 받은 insert 할 정보를 쿼리 형태로 처리하기 위해 xml파일로 전달
	public int insertRealEstate(RealEstate realEstate);
	
	// 전달받은 값을 쿼리 처리를 위해 xml 파일로 전달
	public int insertRealEstateByParameter(
			@Param("realtorId") int realtorId
			, @Param("address") String address
			, @Param("area") int area
			, @Param("type") String type
			, @Param("price") int price
			, @Param("rentPrice") int rentPrice);
	
	// 전달받은 객체를 update 쿼리 실행을 위해 xml 파일로 전달
	public int updateRealEstate(RealEstate realEstate);
	
	// 전달 받은 객체를 delete 쿼리 실행을 위해 xml 파일로 전달
	public int deleteRealEstate(RealEstate realEstate);
}
