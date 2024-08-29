package com.kyung.spring.test.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kyung.spring.test.jpa.domain.Recruit;
import com.kyung.spring.test.jpa.repository.RecruitRepository;

@Controller
@RequestMapping("/jpa/test2")
public class RecruitController {
	private static final int ArrayList = 0;
	@Autowired
	RecruitRepository recruitRepository;
	
	// 1. id로 조회
	@GetMapping("/1")
	@ResponseBody
	public Recruit recruitSelectId() {
		
		Optional<Recruit> optionalRecruit = recruitRepository.findById(8);
		Recruit recruit = optionalRecruit.orElse(null);
		
		return recruit;	
	}
	
	// 2. parameter 조건 조회
	@GetMapping("/2")
	@ResponseBody
	public List<Recruit> recruitSelectParameter(@RequestParam("companyid") int companyid){
		List<Recruit> recruitList = new ArrayList<>();
		
		Optional<Recruit> optionalRecruit = recruitRepository.findById(companyid);
		Recruit recruit = optionalRecruit.orElse(null);
		
		recruitList.add(recruit);
		
		return recruitList;
	}
	
	// 3. 복합 조건 조회
	@GetMapping("/3")
	@ResponseBody
	public List<Recruit> recruitSelectDouble(){
		List<Recruit> recruitList = new ArrayList<>();
		
		String position = "웹 back-end 개발자";
		String type = "정규직";
		
		recruitList = recruitRepository.findByPositionAndType(position, type);
		
		return recruitList;
	}
	
	// 4. 복합 조건 조회
	@GetMapping("/4")
	@ResponseBody
	public List<Recruit> recruitSelectDouble2(){
		List<Recruit> recruitList = new ArrayList<>();
		
		String type = "정규직";
		int salary = 9000;
		
		recruitList = recruitRepository.findByTypeOrSalaryGreaterThanEqual(type, salary);
		
		return recruitList;
	}
	
	// 5. 정렬 제한 조건
	@GetMapping("/5")
	@ResponseBody
	public List<Recruit> recruitSelectArray(){
		List<Recruit> recruitList = new ArrayList<>();
		
		String type = "계약직";
		
		recruitList = recruitRepository.findByTypeOrderBySalaryDesc(type);
		
		return recruitList;
	}
	
	// 6. 범위 조회
	@GetMapping("/6")
	@ResponseBody
	public List<Recruit> recruitSelectBetween(){
		List<Recruit> recruitList = new ArrayList<>();
		
		String region = "성남시 분당구";
		int start = 7000;
		int end = 8500;
		
		recruitList = recruitRepository.findByRegionAndSalaryBetween(region, start, end);
		
		return recruitList;
	}
	
	// 7. Native query
	@GetMapping("/7")
	@ResponseBody
	public List<Recruit> recruitNativeQuery(){
		List<Recruit> recruitList = new ArrayList<>();
		
		String deadline = "2026-04-10";
		int salary = 8100;
		String type = "정규직";
		recruitList = recruitRepository.selectByJob(deadline, salary, type);
		
		return recruitList;
	}
}
