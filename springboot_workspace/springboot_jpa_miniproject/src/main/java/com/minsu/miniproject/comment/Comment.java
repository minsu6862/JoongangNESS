package com.minsu.miniproject.comment;

import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.data.annotation.CreatedDate;

import com.minsu.miniproject.board.Board;
import com.minsu.miniproject.member.Member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comments")
@SequenceGenerator(
		name = "COMMENTS_SEQ_GENERATOR",
		sequenceName = "COMMENTS_SEQ",
		initialValue = 1,
		allocationSize = 1
		)
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "COMMENTS_SEQ_GENERATOR")
	private Integer id;
	
	@Column(length = 500)
	private String content;
	
	@CreatedDate
	private LocalDateTime createDate;
	
	@ManyToOne
	private Board board;
	
	@ManyToOne
	private Member member;
	
	private LocalDateTime modifyDate;
	
	@ManyToMany
	Set<Member> voter;
	
	@ManyToMany
	Set<Member> disvoter;
}
