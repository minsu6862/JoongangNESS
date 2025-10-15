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
public class BoardDto {

	@NotBlank(message = "제목을 입력해 주세요.")
	@Size(min = 5, message = "제목 최소 5글자 이상입니다.")
	private String title;
	
	@NotBlank(message = "내용을 입력해 주세요.")
	@Size(min = 5, message = "내용은 최소 5글자 이상입니다.")
	private String content;
}
