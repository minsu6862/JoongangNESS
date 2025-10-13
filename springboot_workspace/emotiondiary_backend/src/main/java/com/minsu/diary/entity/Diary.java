package com.minsu.diary.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Diary {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; //기본키->일기 번호
	
	private String content; //일기 내용
	private String emotionId; //일기 감정이미지 번호
	private Long date; //날짜타입 밀리세컨드 단위 날짜->날짜 타입 x
	
}