package com.minsu.board.usertest;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
//json으로 반환할때 null값 가진 필드는 제외하고 반환하라는 뜻
public class UserTest3 {
	
	private String username;
	private String password;
	
}
