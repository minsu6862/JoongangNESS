package com.minsu.miniproject.board;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.CreatedDate;

import com.minsu.miniproject.comment.Comment;
import com.minsu.miniproject.member.Member;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "board")
@SequenceGenerator(
		name = "BOARD_SEQ_GENERATOR",
		sequenceName = "BOARD_SEQ",
		initialValue = 1,
		allocationSize = 1
		)
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "BOARD_SEQ_GENERATOR")
	private Integer id;
	
	@Column(length = 200)
	private String subject;
	
	@Column(length = 500)
	private String content;
	
	@CreatedDate
	private LocalDateTime createDate;
	
	@OneToMany(mappedBy = "board", cascade = CascadeType.REMOVE)
	private List<Comment> commentList;
	
	@ManyToOne
	private Member author;
	
	private LocalDateTime modifyDate;
	
	@ManyToMany
	Set<Member> voter;
	
	@ManyToMany
	Set<Member> disvoter;
	
	private Integer hit = 0;	//조회수
}
