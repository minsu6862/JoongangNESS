package com.minsu.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	
	@RequestMapping(value = "/index")
	public String index() {
		
		
		return "index";	//실제 실행될 jsp이름
	}
	
	@RequestMapping(value = "/boardList")
	public String boardList() {
		
		
		return "boardList";	//실제 실행될 jsp이름
	}
	
	@RequestMapping(value = "/join")
	public String join	() {
		
		
		return "member/joinMember";	//실제 실행될 jsp이름
	}
}
