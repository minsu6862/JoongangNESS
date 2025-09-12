package com.minsu.msboard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	//로컬용 루트
	//@GetMapping(value = "/")
	
	//클라우드용 루트
	@GetMapping(value = "/")
	public String root() {
		
		return "redirect:/question/list";
	}
}
