package com.minsu.member.dto;

import java.security.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {

	private int membernum;
	private String memberid, membername, memberpw;
	
	private Timestamp memberdate;
}
