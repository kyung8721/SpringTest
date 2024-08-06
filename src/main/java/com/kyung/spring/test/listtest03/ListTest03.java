package com.kyung.spring.test.listtest03;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ListTest03 {
	
	@RequestMapping("/listTest/test03")
	public String listTest03() {
		return "listTest03/test03";
	}
}
