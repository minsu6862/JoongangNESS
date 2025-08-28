package com.minsu.member.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.minsu.member.dto.MemberDto;
import com.minsu.member.validation.MemberValidator;

@Controller
public class MemberController {
	
	@RequestMapping(value = "/memberJoin")
	public String memberJoin() {
		
		return "memberJoin";
	}
	
	@RequestMapping(value = "/memberJoinOk")
	public String memberJoinOk(@ModelAttribute MemberDto memberDto, Model model, BindingResult result) {
		MemberValidator memberValidator = new MemberValidator();
		memberValidator.validate(memberDto, result);
		
		if(result.hasErrors()) {	//에러가 있는지 유효성 체크
			List<ObjectError> allErrors = result.getAllErrors();
			List<String> errorMsg = new ArrayList<String>();
			
			for(ObjectError error : allErrors) {
				errorMsg.add(error.getDefaultMessage());
			}
			
			model.addAttribute("signUpError", "회원가입에 실패했습니다.");
			model.addAttribute("errorMsg", errorMsg);
			
			//가입화면에서 유저가 입력한 내용을 다시 보여주기 위해 memberDto를 가입화면으로 전송
			model.addAttribute("memberDto", memberDto);
			
			return "memberJoin";
		}
		
		model.addAttribute("memberDto", memberDto);
		return "memberJoinOk";
	}
}
