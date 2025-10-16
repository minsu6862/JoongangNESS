package com.minsu.home.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
	
	@NotBlank(message = "댓글 내용은 필수 입력 사항입니다.")
	@Size(min = 5, message = "글 내용은 최소 5글자 이상이어야 합니다.")
	private String content;	//댓글 내용
	
}
