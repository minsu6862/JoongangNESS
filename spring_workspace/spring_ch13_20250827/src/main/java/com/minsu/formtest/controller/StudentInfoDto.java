package com.minsu.formtest.controller;

public class StudentInfoDto {
	private String name, email;

	public StudentInfoDto() {
		super();
	}

	public StudentInfoDto(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
