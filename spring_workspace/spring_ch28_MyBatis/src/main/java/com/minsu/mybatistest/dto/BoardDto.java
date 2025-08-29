package com.minsu.mybatistest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {
	
	private int board_num;
	private String board_title, board_content, board_name;
	private int board_hit;
	private String board_date;
}
