package com.kyung.spring.test.jpa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyung.spring.test.jpa.domain.Company;
import com.kyung.spring.test.jpa.repository.CompanyRepository;

@Service

public class CompanyService {
	@Autowired
	private CompanyRepository companyRepository;
	
	// Create
	public Company createCompanyService(String name
			, String business
			, String scale
			, int headcount) {
		
		Company company = Company.builder()
				.name(name)
				.business(business)
				.scale(scale)
				.headcount(headcount)
				.build();
		
		Company result = companyRepository.save(company);
		
		return result;
	}
	
	// Update
	public Company updateCompanyService(int id, String scale, int headcount){
		
		// id로 찾기
		Optional<Company> optionalCompanyId = companyRepository.findById(id);
		
		Company company = optionalCompanyId.orElse(null);
		
		company = company.toBuilder()
				.scale(scale)
				.headcount(headcount)
				.build();
		
		Company result = companyRepository.save(company); // repository로 넘겨서 업데이트
		
		return result;
	}
	
	// Delete
	public void deleteCompanyService(int id){
		// id로 찾기
		Optional<Company> optionalCompanyId = companyRepository.findById(id);
		// Company company = optionalCompanyId.orElse(null);
//		if(company != null) {
//			companyRepository.delete(company);
//		}
		
		if((optionalCompanyId).isPresent()){
			companyRepository.delete(optionalCompanyId.get());
		}
		
		// null이 아닐 때 수행할 기능을 등록
		// c : entity class 객체를 의미
		optionalCompanyId.ifPresent(c -> companyRepository.delete(c));
		
	}
}


