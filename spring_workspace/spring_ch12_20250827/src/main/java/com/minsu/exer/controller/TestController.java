package com.minsu.exer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/record")
public class TestController {

	@RequestMapping(value = "/hello")	//사용자가 요청한 주소 문자열(jsp랑 이름 달라도 됌)
	public String hello() {
		
		return "hello";	//실행되는 jsp이름
	}
	
	@RequestMapping(value = "/board/hello")	//사용자가 요청한 주소 문자열(jsp랑 이름 달라도 됌)
	public String board() {
		
		return "hello";	//실행되는 jsp이름
	}
	
	@RequestMapping(value = "/kbo")	//사용자가 요청한 주소 문자열(jsp랑 이름 달라도 됌)
	public String kbo(Model model) {
		//kbo.jsp가 받을 데이터를 model 객체로 전달
		String rank1 = "롯데";
		String rank2 = "한화";
		model.addAttribute("rank1", rank1);
		model.addAttribute("rank2", rank2);
		
		return "record/kbo";	//실행되는 jsp이름
	}
	
	@RequestMapping(value = "/mlb")	//사용자가 요청한 주소 문자열(jsp랑 이름 달라도 됌)
	public ModelAndView mlb(Model model) {
		ModelAndView mv = new ModelAndView();
		String rank1 = "LA";
		String rank2 = "SF";
		
		mv.addObject("rank1", rank1);	//model 객체에 데이터 전달
		mv.addObject("rank2", rank2);	//model 객체에 데이터 전달
		
		mv.setViewName("record/mlb");	//view(jsp)의 이름 설정
		
		return mv;	//실행되는 jsp이름
	}
}
