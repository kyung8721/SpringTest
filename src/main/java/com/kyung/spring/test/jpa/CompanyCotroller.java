package com.kyung.spring.test.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kyung.spring.test.jpa.domain.Company;
import com.kyung.spring.test.jpa.service.CompanyService;

@Controller
@RequestMapping("/jpa")
public class CompanyCotroller {
	@Autowired
	private CompanyService companyService;
	
	@GetMapping("/create")
	@ResponseBody
	public List<Company> createCompany() {
		
		// 저장한 값을 넣을 리스트 생성
		List<Company> companyList = new ArrayList<>();
		
		// 저장할 값 넣어서 서비스로 전달
		Company company = companyService.createCompanyService(
				"넥손"
				, "컨텐츠 게임"
				, "대기업"
				, 3585);
		companyList.add(company); // 리스트에 저장
		
		company = companyService.createCompanyService(
				"버블팡"
				, "여신 금융업"
				, "대기업"
				, 6934);
		
		companyList.add(company);
		
		
		return companyList;
	}
	
	// Update
	@GetMapping("/update")
	@ResponseBody
	public Company updateCompany() {
		Company company = companyService.updateCompanyService(
				8
				, "중소기업"
				, 34);
		return company;
	}
	
	// Delete
	@GetMapping("/delete")
	@ResponseBody
	public String deleteCompany() {
		companyService.deleteCompanyService(8);
		
		return "수행 완료";
	}
	
}


