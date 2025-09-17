package com.minsu.miniproject.comment;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CommentForm {
	
	@NotEmpty(message = "공백은 댓글로 작성하실 수 없습니다.")
	@Size(max = 300)
	@Size(min = 3)
	private String content;
}
