package com.minsu.board.usertest;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UserTest4 {
	
	@JsonProperty("user_name")	//해당 필드의 json으로 변환될 때 필드 이름을 변경
	private String username;
	
	private String password;
	
}
