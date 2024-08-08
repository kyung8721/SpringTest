package com.kyung.spring.test.Store.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kyung.spring.test.Store.domain.Store;

@Mapper
public interface StoreRepository {
	
	//store의 모든 행 조회
	public List<Store> selectStoreList();
}
