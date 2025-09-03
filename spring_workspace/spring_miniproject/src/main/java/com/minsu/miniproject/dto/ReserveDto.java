package com.minsu.miniproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReserveDto {
	private String seatname;
	private int reserved;
	private String reserveid;
	
	private MemberDto memberDto;
}
