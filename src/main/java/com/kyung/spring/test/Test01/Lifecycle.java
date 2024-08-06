package com.kyung.spring.test.Test01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/lifecycle/test01")
public class Lifecycle {
	
	@ResponseBody
	@RequestMapping("/1")
	public String title() {
		return "<h1>테스트 프로젝트 완성</h1>"
				+ "<div>해당 프로젝트를 통해서 문제 풀이를 진행 합니다.</div>";
	}
	
	@ResponseBody
	@RequestMapping("/2")
	public Map<String, Integer> score(){
		Map<String, Integer> scoreMap = new HashMap<>();
		
		scoreMap.put("국어", 80);
		scoreMap.put("수학", 90);
		scoreMap.put("영어", 85);
		
		return scoreMap;
		// 스프링에서 자동으로 jackson library를 이용해서 json 형태로 바꿔줌
		
	}

}
