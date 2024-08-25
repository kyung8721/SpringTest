package com.kyung.spring.test.ajax;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kyung.spring.test.ajax.domain.Url;
import com.kyung.spring.test.ajax.service.UrlService;

@Controller
@RequestMapping("/ajax/url")
public class UrlController {
	
	
	// 서비스 객체 생성
	@Autowired
	private UrlService urlService;
	
	// 리스트 불러오고 화면에 보여주기
	@GetMapping("/info")
	public String urlInfo(Model model) {
		
		// Url 객체 생성
		Url url = new Url();
		
		// 리스트 생성
		List<Url> urlList= new ArrayList<>();
		
		urlList = urlService.urlInfoService();
		
		model.addAttribute("urlList", urlList);
		
		return "ajax/url/list";
	}
	
	// 즐겨찾기 추가
	// API
	@PostMapping("/insert")
	@ResponseBody
	public Map<String, String> urlInsert(
			@RequestParam("name") String name
			, @RequestParam("url") String url) {
		
		// Url 객체 생성
		Url urlObject = new Url();
		
		// 객체에 값 추가
		urlObject.setName(name);
		urlObject.setUrl(url);
		
		
		int count = urlService.urlInsertService(urlObject);
		
		// json 문자열로 response에 데이터를 채움
		// 성공여부
		// {"result" : "success"}
		// {"result" : "fail"}
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1) {
			// 성공
			resultMap.put("result", "success");
		} else {
			// 실패
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
	// 추가 페이지로 이동
	@GetMapping("/add")
	public String urlAdd() {
		
		return "ajax/url/add";
	}
	
	// url 중복확인 API
	@PostMapping("/duplicate")
	@ResponseBody
	public Map<String, Boolean> isDuplicateUrl(
			@RequestParam("url") String url){
		boolean isDuplicate = urlService.urlDuplicateService(url);
		
		Map<String, Boolean> resultMap = new HashMap<>();
		// {"result" : true}
		// {"result" : false}
		resultMap.put("result", isDuplicate);
		
		return resultMap;

	}
	
	// 즐겨찾기 목록 삭제 API
	@GetMapping("/delete")
	@ResponseBody
	public Map<String, String> urlDelete(
			@RequestParam("id") int id){
		

		int count = urlService.urlDeleteService(id);
		
		// {"result" : "success"}
		// {"result" : "false"}
		Map<String, String> resultMap = new HashMap<>();
		
		if(count >= 1) {
			// 삭제 성공
			resultMap.put("result", "success");
		}else{
			// 삭제 실패
			resultMap.put("result", "false");
		}
		
		return resultMap;
	}
}
