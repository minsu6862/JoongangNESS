package com.minsu.validate;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/join")
	public String join() {
		
		return "join";
	}
	
	@RequestMapping(value = "/join2")
	public String join2() {
		
		return "join2";
	}
	
	@RequestMapping(value = "/joinOk")
	public String joinOk(StudentDto studentDto, Model model, BindingResult result) {
		
		//아이디와 비밀번호가 공란이거나 나머지가 20세 미만이어야 가입 가능
		StudentValidator validator = new StudentValidator();
		validator.validate(studentDto, result);
		
		if(result.hasErrors()) {	//result내에 error가 1개라도 있으면 true, 없으면 false
			System.out.println("에러 발생 개수 : " + result.getFieldErrorCount());
			FieldError fieldError = result.getFieldError("id");	//해당 필드의 에러내용 가져오기
			System.out.println(fieldError.getCode());	//id필드의 에러코드 가져오기
			List<FieldError> fieldErrors = result.getFieldErrors(); //모든 에러를 list로 반환
			for(FieldError error : fieldErrors) {
				System.out.println("------------------------------------");
				System.out.println("에러가 발생한 항목 : " + error.getField());
				System.out.println("에러가 발생한 코드명 : " + error.getCode());
			}
			
			model.addAttribute("error", "error");
			return "join";	//가입 실패이므로 회원가입페이지로 다시 돌려보냄
		}
		
		model.addAttribute("studentDto", studentDto);
		
		return "joinOk";	//회원 가입 성공 페이지로 이동
	}
	
	@RequestMapping(value = "/joinOk2")
	public String joinOk2(@Valid StudentDto studentDto, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "join";
		} else {
			model.addAttribute("studentDto", studentDto);
			return "joinOk";
		}
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new StudentValidator());
	}
	
}
