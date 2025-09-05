package com.minsu.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	
	@RequestMapping(value = "/hello")
	public String hello() {
		
		return "hello";
	}
	
	@GetMapping(value = "/world")
	@ResponseBody
	public String world() {
		
		return "hello!!!";
	}
	
}
