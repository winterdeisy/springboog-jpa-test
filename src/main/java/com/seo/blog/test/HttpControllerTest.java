package com.seo.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//사용자가 요청 -> 응답(html) @Controller
//사용자가 요청 -> 응답(data) @RestController

@RestController
public class HttpControllerTest {
	private static final String TAG = "HttpControllerTest: ";
	@GetMapping("/http/lombok")
	public String lombokTest() {
		Member m = new Member(1, "ssar", "1234", "email");
		//builder 패턴
		Member m2 = Member.builder().username("seo").password("123").email("seo@nate.com").build();
		System.out.println(TAG+"getter: "+m.getId());
		m.setId(5000);
		System.out.println(TAG+"setter: "+m.getId());
		return "lombok test 완료";
	}
	//인터넷 브라우저는 get 요청만 가능
	//http://localhost:8080/http/get
	@GetMapping("/http/get")
	public String getTest(Member m) {
		return "get 요청: "+m.getId() +","+m.getUsername() +","+m.getPassword()
		+","+m.getEmail();
	}

	//http://localhost:8080/http/post
	@PostMapping("/http/post")
	public String postTest(@RequestBody Member m) { //messageConverter
		return "post 요청: "+m.getId() +","+m.getUsername() +","+m.getPassword()
		+","+m.getEmail();
	}
	//http://localhost:8080/http/put
	@PutMapping("/http/put")
	public String putTest(@RequestBody Member m) {
		return "put 요청: "+m.getId() +","+m.getUsername() +","+m.getPassword()
		+","+m.getEmail();
	}
	//http://localhost:8080/http/delete
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "delete 요청";
	}
	
}
