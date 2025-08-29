package com.minsu.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	
	@RequestMapping(value = "/loginForm.do")
	public String loginForm() {
		
		return "loginForm";
	}
	
	@RequestMapping(value = "/login.do")
	public String login() {
		
		return "login";
	}
	
	@RequestMapping(value = "/admin.do")
	public String admin() {
		
		return "admin";
	}

	@RequestMapping(value = "/logout.do")
	public String logout() {
		
		return "logout";
	}
	
	@RequestMapping(value = "/user.do")
	public String user() {
		
		return "user";
	}
	
}
