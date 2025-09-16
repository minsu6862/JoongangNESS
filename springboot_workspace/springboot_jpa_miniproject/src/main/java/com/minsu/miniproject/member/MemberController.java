package com.minsu.miniproject.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/member")
public class MemberController {

    private final AuthenticationManager authenticationManager;

	@Autowired
	MemberService memberService;

    MemberController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
	
	@GetMapping(value = "/signup")
	public String signup(MemberCreateForm memberCreateForm) {
		return "signup_form";
	}
	
	@PostMapping(value = "/signup")
	public String signup(@Valid MemberCreateForm memberCreateForm, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "signup_form";
		}
		
		if(!memberCreateForm.getPassword1().equals(memberCreateForm.getPassword2())) {
			bindingResult.rejectValue("password", "passwordInCorrect", "비밀번호 확인이 서로 일치하지 않습니다.");
			return "signup_form";
		}
		
		try {
			memberService.create(memberCreateForm.getMemberName(), memberCreateForm.getPassword1(), memberCreateForm.getAge());
		} catch (DataIntegrityViolationException e) {
			e.printStackTrace();
			bindingResult.reject("signupFailed", "이미 등록된 사용자입니다.");
			return "signup_form";
		} catch (Exception e) {
			e.printStackTrace();
			bindingResult.reject("signupFailed", "회원 가입에 실패하였습니다.");
			return "signup_form";
		}
		
		return "redirect:/";
	}
	
	@GetMapping(value = "/login")
	public String login() {
		
		return "login_form";
	}
	
}
