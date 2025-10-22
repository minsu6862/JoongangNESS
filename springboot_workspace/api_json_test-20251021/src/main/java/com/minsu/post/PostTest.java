package com.minsu.post;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.minsu.board.usertest.UserTest5;

public class PostTest {

	private String title;
	private String content;
	
	@JsonIgnore
	private UserTest5 userTest5;
}
