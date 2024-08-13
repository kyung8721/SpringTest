package com.kyung.spring.test.seller.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kyung.spring.test.seller.domain.Seller;

@Mapper
public interface SellerRepository {
	// seller 추가입력
	public int insertSeller(Seller seller);
	
	// 마지막으로 불러온 seller 정보 조회 쿼리로 넘기기
	public Seller lastSeller();
	
	// id로 seller 조회 쿼리로 파라미터 전달
	public Seller sellerInquire(@Param("id") int id);
}
