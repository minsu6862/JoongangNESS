package com.minsu.board.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor			//기본생성자
@AllArgsConstructor			//모든 매개변수 포함 생성자
public class BoardDto {
	private int board_num;
	private String board_title, board_content, board_name;
	private int board_hit;
	private String board_date;
}
