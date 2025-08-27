package com.minsu.formtest.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RedirectController {

	@RequestMapping(value = "/studentInput")
	public String studentInput() {
		
		return "studentInput";
	}
	
	@RequestMapping(value = "/studentCheck")
	public String studentCheck(@RequestParam("studentId") String studentId, Model model, HttpServletResponse response) {
		
		if(studentId.equals("tiger")) {
			return "redirect: studentGood";
			//return "studentGood";
		} else {
			return "redirect: studentNg";	//redirect 다음에 나오는 문자열은 요청이지 jsp파일이 아님
			//return "studentNg";
		}
	}
	
	@RequestMapping(value = "/studentNg")
	public String studentNg(Model model) {
		model.addAttribute("studentId", "tiger");
		
		return "studentNg";
	}
	
	@RequestMapping(value = "/studentGood")
	public String studentGood(Model model) {
		model.addAttribute("studentId", "tiger");
		
		return "studentGood";
	}
	
	
}
