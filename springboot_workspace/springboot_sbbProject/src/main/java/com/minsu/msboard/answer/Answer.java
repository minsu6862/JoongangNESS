package com.minsu.msboard.answer;

import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.data.annotation.CreatedDate;

import com.minsu.msboard.question.Question;
import com.minsu.msboard.user.SiteUser;

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
@Table(name = "answer")	//실제로 매핑될 데이터베이스의 테이블 이름 설정
@SequenceGenerator(
		name = "ANSWER_SEQ_GENERATOR",	//JPA 내부 시퀀스 이름
		sequenceName = "ANSWER_SEQ",		//실제 시퀀스 이름
		initialValue = 1,	//시퀀스 시작값
		allocationSize = 1	//시퀀스 증가치
		)
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "ANSWER_SEQ_GENERATOR")
	private Integer id;
	
	@Column(length = 500)
	private String content;
	
	@CreatedDate
	private LocalDateTime createDate;
	
	//N:1 관계 -> 답변:질문
	@ManyToOne
	private Question question;
	
	//N:1 관계->답변:작성자
	@ManyToOne
	private SiteUser author; //글쓴이(1명)
	
	private LocalDateTime modifyDate;	//답변 글 수정 일시
	
	@ManyToMany
	Set<SiteUser> voter;	//추천한 유저
	
	@ManyToMany
	Set<SiteUser> disvoter;	//비추천한 유저
}
