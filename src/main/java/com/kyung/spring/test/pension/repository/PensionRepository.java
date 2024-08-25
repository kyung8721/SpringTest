package com.kyung.spring.test.pension.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kyung.spring.test.pension.domain.Booking;

@Mapper
public interface PensionRepository {
	public List<Booking> pensionListRepository();
	
	public int bookingDeleteRepository(int id);
	
	public int bookingInsertRepository(Booking booking);
	
	public Booking bookingCheckRepository(@Param("name") String name, @Param("phoneNumber") String phoneNumber);
}
