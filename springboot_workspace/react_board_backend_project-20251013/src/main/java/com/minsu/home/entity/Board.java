package com.minsu.home.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	private String content;

	@CreationTimestamp	//자동으로 insert시 날짜 삽입
	private LocalDateTime createDate;
	
	@ManyToOne	//N:1 관계 -> 게시판 글 : 유저
	private SiteUser author;	//게시판 글쓴이
	
}
