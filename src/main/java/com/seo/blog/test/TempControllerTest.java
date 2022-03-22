package com.seo.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempControllerTest {

	//http://localhost8000/blog/temp/home
	@GetMapping("/temp/home")
	public String tempHome() {
		System.out.println("tempHome()");
		//파일리턴 기본경로 : src/main/resource/static
		//리턴명 : /home.html
		//풀경로 : src/main/resource/static/home.html
		return "/home.html";
	}
	@GetMapping("/temp/jsp")
	public String tempJsp() {
		return "test";
	}
}
