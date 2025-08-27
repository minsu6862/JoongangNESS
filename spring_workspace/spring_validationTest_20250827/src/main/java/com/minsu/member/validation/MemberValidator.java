package com.minsu.member.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.minsu.member.dto.MemberDto;

public class MemberValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		MemberDto memberDto = (MemberDto) target;
		String id = memberDto.getId();
		String password = memberDto.getPassword();
		String name = memberDto.getName();
		int age = memberDto.getAge();
		String email = memberDto.getEmail();
		String confirmPassword = memberDto.getConfirmPassword();
		
		//아이디가 공란인지 확인
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "id.empty", "아이디는 필수 입력 사항입니다.");
		
		//아이디의 길이가 5자 이상인지 확인
		if(id != null && id.length() < 5) {	//조건이 참이면 에러
			errors.rejectValue("id", "id.short", "아이디는 5자 이상이어야 합니다.");
		}
		
		//비밀번호 확인(confirmPassword 일치 여부)
		if(!password.equals(confirmPassword)) {
			errors.rejectValue("confirmPassword", "id.mismatch", "비밀번호 확인이 일치하지 않습니다.");
		}
		
	}

}
