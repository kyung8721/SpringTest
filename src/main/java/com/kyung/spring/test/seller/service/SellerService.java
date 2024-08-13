package com.kyung.spring.test.seller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyung.spring.test.seller.domain.Seller;
import com.kyung.spring.test.seller.repository.SellerRepository;

@Service
public class SellerService {
	@Autowired
	private SellerRepository sellerRepository;
	
	public int sellerInsertService(Seller seller) {
		int count = sellerRepository.insertSeller(seller);
		
		return count;
	}
	
	// 마지막으로 추가된 seller 조회
	public Seller getLastseller() {
		Seller Lastseller = sellerRepository.lastSeller();
		
		return Lastseller;
	}
	
	// id로 seller조회
	public Seller getSeller(int id) {
		Seller sellerInquire = sellerRepository.sellerInquire(id);
		
		return sellerInquire;
	}
}
