package com.minsu.miniproject.member;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class MemberCreateForm {
	
	@Size(min=3, max=30, message = "사용자 ID의 길이는 3~30 사이로 입력하셔야 합니다.")
	@NotEmpty(message = "사용자 ID는 필수 입력사항입니다.")
	private String memberName;
	
	@NotEmpty(message = "사용자 비밀번호는 필수 입력사항입니다.")
	private String password1;
	
	@NotEmpty(message = "사용자 비밀번호 확인은 필수 입력사항입니다.")
	private String password2;
	
	@NotNull(message = "사용자 나이는 필수 입력사항입니다.")
	private int age;
}
