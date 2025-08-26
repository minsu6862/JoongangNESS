package com.minsu.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/gallery")	//모든 메소드 value값 앞에 gallery를 붙힌 효과
public class GalleryController {

	@RequestMapping(value = "/join")
	public String join() {
		
		
		return "gallery/join";	//실제 실행될 jsp이름
	}
	
	@RequestMapping(value = "/list")
	public String list() {
		
		
		return "gallery/list";	//실제 실행될 jsp이름
	}
	
	@RequestMapping(value = "/view")
	public String view() {
		
		
		return "gallery/view";	//실제 실행될 jsp이름
	}
}
