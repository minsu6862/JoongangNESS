package com.minsu.test;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/test")
	public String home() {
		
		
		return "home";
	}
	
	@RequestMapping(value = "/hello")
	public String hello() {
		
		
		return "hello";
	}
	
}
