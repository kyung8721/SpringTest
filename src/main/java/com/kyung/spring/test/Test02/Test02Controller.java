package com.kyung.spring.test.Test02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lifecycle/test02")
public class Test02Controller {
	
	@ResponseBody
	@RequestMapping("/1")
	public List<Map<String, Object>> movie() {

		Map<String, Object> movieMap = new HashMap<>();
		
		ArrayList<Map<String, Object>> movies = new ArrayList<>();
		
		movieMap.put("rate", 15);
		movieMap.put("director", "봉준호");
		movieMap.put("time", 131);
		movieMap.put("title", "기생충");
		movies.add(movieMap);
		
		movieMap = new HashMap<>();
		movieMap.put("rate", 0);
		movieMap.put("director", "로바르토 베니니");
		movieMap.put("time", 116);
		movieMap.put("title", "인생은 아름다워");
		movies.add(movieMap);
		
		movieMap = new HashMap<>();
		movieMap.put("rate", 12);
		movieMap.put("director", "크리스토퍼 놀란");
		movieMap.put("time", 147);
		movieMap.put("title", "인셉션");
		movies.add(movieMap);
		
		movieMap = new HashMap<>();
		movieMap.put("rate", 19);
		movieMap.put("director", "윤종빈");
		movieMap.put("time", 133);
		movieMap.put("title", "범죄와의 전쟁 : 나쁜 놈들 전성시대");
		movies.add(movieMap);
		
		movieMap = new HashMap<>();
		movieMap.put("rate", 15);
		movieMap.put("director", "프란시스 로렌스");
		movieMap.put("time", 137);
		movieMap.put("title", "헝거게임");
		movies.add(movieMap);
		
		return movies;
	}
	
	@ResponseBody
	@RequestMapping("/2")
	public List<Content> ContentBoard() {
		Content content1 = new Content("안녕하세요 가입인사 드립니다", "hagulu", "안녕하세요. 가입했어요. 앞으로 잘 부탇그립니다. 활동 열심히 하겠습니다.");
		Content content2 = new Content("헐 대박", "bada", "오늘 목요일이었어... 금요일인줄");
		Content content3 = new Content("오늘 데이트 한 이야기 해드릴게요", "dulumary", "......");
		
		List<Content> contentBoard = new ArrayList<>();
		
		contentBoard.add(content1);
		contentBoard.add(content2);
		contentBoard.add(content3);
		
		return contentBoard;
	}
	
	@ResponseBody
	@RequestMapping("/3")
	public ResponseEntity<Content> ContentEntity(){
		Content content = new Content("안녕하세요 가입인사 드립니다", "hagulu", "안녕하세요. 가입했어요. 앞으로 잘 부탇그립니다. 활동 열심히 하겠습니다.");
		
		ResponseEntity<Content> contentError = new ResponseEntity(content, HttpStatus.INTERNAL_SERVER_ERROR);
		
		return contentError;
	}

}
