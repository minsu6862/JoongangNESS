package com.minsu.todo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Todo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; //할일의 고유번호 id
	
	private String content; //할일 내용
}