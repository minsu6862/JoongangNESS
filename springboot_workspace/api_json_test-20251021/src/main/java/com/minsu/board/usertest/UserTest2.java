package com.minsu.board.usertest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties({"password", "email"})
//password, email 필드 2개가 동시에 json으로 변환될 때 포함되지 않음
public class UserTest2 {
	
	private String username;
	private String password;
	private String email;
	
}
