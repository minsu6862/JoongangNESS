package com.minsu.msboard.answer;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AnswerForm {

	@NotEmpty(message = "내용은 필수 항목입니다.")	//내용이 공란으로 들어오면 작동
	@Size(max=500)
	@Size(min=5)
	private String content;
}
