package com.kyung.spring.test.thymeleaf;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kyung.spring.test.thymeleaf.domain.Member;
import com.kyung.spring.test.thymeleaf.domain.Weather;
import com.kyung.spring.test.thymeleaf.service.ThymeleafService;

@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {
	
	@GetMapping("/test01")
	public String thymeleafResult() {
		return "thymeleaf/test01";
	}
	
	@GetMapping("/test02")
	public String thymeleafTest02(Model model) {
		
		List<String> musicRanking = new ArrayList<>();
		musicRanking.add("강남스타일");
		musicRanking.add("벚꽃엔딩");
		musicRanking.add("좋은날");
		musicRanking.add("거짓말");
		musicRanking.add("보고싶다");
		
		model.addAttribute("musicRanking", musicRanking);
		
		return "thymeleaf/test02";
	}
	
	@GetMapping("/test03")
	public String thymeleafTest03(Model model) {
		List<Map<String, Object>> membership = new ArrayList<>();

		Map<String, Object> member = new HashMap<>();
		member.put("name", "손오공");
		member.put("phoneNumber", "010-1234-5678");
		member.put("grade", "VIP");
		member.put("point", 12040);
		membership.add(member);

		member = new HashMap<>();
		member.put("name", "저팔계");
		member.put("phoneNumber", "010-4321-1234");
		member.put("grade", "BASIC");
		member.put("point", 3420);
		membership.add(member);

		member = new HashMap<>();
		member.put("name", "사오정");
		member.put("phoneNumber", "010-8888-1111");
		member.put("grade", "GOLD");
		member.put("point", 1530);
		membership.add(member);

		member = new HashMap<>();
		member.put("name", "삼장");
		member.put("phoneNumber", "010-0000-1234");
		member.put("grade", "GOLD");
		member.put("point", 8450);
		membership.add(member);

		member = new HashMap<>();
		member.put("name", "우마왕");
		member.put("phoneNumber", "010-1111-2222");
		member.put("grade", "BASIC");
		member.put("point", 420);
		membership.add(member);
		
		model.addAttribute("membership", membership);
		
		return "thymeleaf/test03";
		
	}
	
	@GetMapping("/test04")
	public String test04(Model model){
		
		List<Member> members = new ArrayList<>();

		Member member = new Member();
		member.setName("유비");
		member.setPhoneNumber("010-1234-5678");
		member.setEmail("youbee@gmail.com");
		member.setNationality("삼국시대 촉한");
		member.setIntroduce("저는 촉의 군주 유비입니다. 삼국통일을 위해 열심히 일하겠습니다.");
		member.setBirth(LocalDate.of(161, 7, 9));
		members.add(member);

		member = new Member();
		member.setName("관우");
		member.setPhoneNumber("010-1234-5678");
		member.setEmail("woo@naver.com");
		member.setNationality("삼국시대 촉한");
		member.setIntroduce("관우에요. 저는 유비형님 보다 나이는 많지만 일단 아우입니다.");
		member.setBirth(LocalDate.of(160, 6, 14));
		members.add(member);

		member = new Member();
		member.setName("장비");
		member.setPhoneNumber("02-111-3333");
		member.setNationality("삼국시대 촉한");
		member.setEmail("tools@gmail.com");
		member.setIntroduce("장비라우");
		member.setBirth(LocalDate.of(165, 1, 31));
		members.add(member);

		member = new Member();
		member.setName("조조");
		member.setPhoneNumber("010-0987-4321");
		member.setNationality("삼국시대 위");
		member.setEmail("jojo@gmail.com");
		member.setIntroduce("이름은 조조 자는 맹덕이라 하오");
		member.setBirth(LocalDate.of(155, 5, 3));
		members.add(member);

		member = new Member();
		member.setName("주유");
		member.setPhoneNumber("010-0000-1111");
		member.setNationality("삼국시대 오");
		member.setEmail("jooyou@kakao.com");
		member.setIntroduce("주유는 주유소에서 ㅋㅋ");
		member.setBirth(LocalDate.of(175, 5, 10));
		members.add(member);

		member = new Member();
		member.setName("황충");
		member.setPhoneNumber("031-432-0000");
		member.setNationality("삼국시대 촉한");
		member.setEmail("yellowbug@naver.com");
		member.setIntroduce("내 수염 좀 멋있는 듯");
		member.setBirth(LocalDate.of(143, 8, 22));
		members.add(member);

		model.addAttribute("members", members);
		
		return "thymeleaf/test04";
	}
	
	// 서비스 객체 생성
	@Autowired
	private ThymeleafService thymeleafService;
	
	
	@GetMapping("/test05")
	public String test05(Model model) {
		
		// 데이터 불러오기
		// 서비스 호출
		List<Weather> weatherData = thymeleafService.getthymeleafService();
		
		// model에 입력
		model.addAttribute("weatherData", weatherData);
		
		return "thymeleaf/test05";
	}
	
	// input 페이지로 연결
	@GetMapping("/test05/input")
	public String test05Input() {
		return "thymeleaf/test05Input";
	}
	
	// 입력받은 데이터 insert
	@GetMapping("/test05/insert")
	public String test05Insert(
			@RequestParam("date") LocalDate date
			, @RequestParam("weather") String weather
			, @RequestParam("temperatures") double temperatures
			, @RequestParam("precipitation") double precipitation
			, @RequestParam("microDust") String microDust
			, @RequestParam("windSpeed") double windSpeed) {
		
		// insert
		// 객체생성
		Weather weatherList = new Weather();
		
		// 객체에 값 전달
		weatherList.setDate(date);
		weatherList.setWeather(weather);
		weatherList.setTemperatures(temperatures);
		weatherList.setPrecipitation(precipitation);
		weatherList.setMicroDust(microDust);
		weatherList.setWindSpeed(windSpeed);
		
		// service로 전달
		thymeleafService.setWeatherService(weatherList);
		
		return "redirect:/thymeleaf/test05";
	}
}
