package com.minsu.board.usertest;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class UserTest1 {
	
	private String username;
	
	@JsonIgnore
	//해당 객체의 값이 json으로 변환되어 반환될 때 jsonIgnore를 적용시킨 필드는 json에 포함x
	private String password;
	
}
