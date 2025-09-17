package com.minsu.miniproject.board;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class BoardForm {

	@NotEmpty(message = "제목을 입력해 주십시오")
	@Size(max = 200)
	@Size(min = 1)
	private String subject;
	
	@NotEmpty(message = "내용을 입력해 주십시오")
	@Size(max = 200)
	@Size(min = 1)
	private String content;
}
