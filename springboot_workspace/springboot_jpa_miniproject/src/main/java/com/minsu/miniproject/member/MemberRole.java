package com.minsu.miniproject.member;

import lombok.Getter;

@Getter
public enum MemberRole {

	ADMIN("ROLE_ADMIN"),
	USER("ROLE_MEMBER");

	MemberRole(String value) {
		this.value = value;
	}
	
	private String value;
}
