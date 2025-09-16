package com.minsu.miniproject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainContoller {

	@GetMapping(value = "/")
	public String root() {
		
		return "main";
	}
	
	@GetMapping(value = "/main")  // 이 매핑 추가
    public String main() {
        return "main";
    }
}
