package com.minsu.validate;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class StudentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {	//검증할 객체(studentDto)의 클래스 타입 정보
		// TODO Auto-generated method stub
		return StudentDto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		StudentDto studentDto = (StudentDto) target;
		
		String id = studentDto.getId();	//유저가 가입할 때 입력한 아이디
		String pw = studentDto.getPw();
		int age = studentDto.getAge();
		
		if(id.strip().isEmpty() || id == null) {	//두 조건 중 하나라도 참이면 error
			System.out.println("입력된 아이디 : " + id);
			errors.rejectValue("id", "trouble");	//에러가 발생한 필드 이름, 에러 코드(메세지)
		}
		
		if(pw.strip().isEmpty() || pw == null) {	//두 조건 중 하나라도 참이면 error
			System.out.println("입력된 비밀번호 : " + pw);
			errors.rejectValue("pw", "trouble");	//에러가 발생한 필드 이름, 에러 코드(메세지)
		}
		
		if(age > 19 || age < 0) {
			System.out.println("입력된 나이 : " + age);
			errors.rejectValue("age", "trouble");	//에러가 발생한 필드 이름, 에러 코드(메세지)
		}
	}

}
