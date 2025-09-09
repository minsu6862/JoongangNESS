package com.minsu.msboard.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserCreateForm {

	@Size(min=3, max=20, message = "사용자 ID의 길이는 3~20사이로 입력해 주셔야 합니다")	//아이디의 길이가 3~20제한
	@NotEmpty(message = "사용자 ID는 필수 항목입니다")
	private String username;

	@NotEmpty(message = "사용자 비밀번호는 필수 항목입니다")
	private String password1;
	
	@NotEmpty(message = "사용자 비밀번호 확인는 필수 항목입니다")
	private String password2;
	
	@NotEmpty(message = "사용자 이메일은 필수 항목입니다")
	@Email	//이메일 형식이 아니면 에러
	private String email;
}
