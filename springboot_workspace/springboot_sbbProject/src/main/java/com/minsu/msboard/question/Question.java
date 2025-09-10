package com.minsu.msboard.question;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;

import com.minsu.msboard.answer.Answer;
import com.minsu.msboard.user.SiteUser;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "question")	//실제로 매핑될 데이터베이스의 테이블 이름 설정
@SequenceGenerator(
		name = "QUESTION_SEQ_GENERATOR",	//JPA 내부 시퀀스 이름
		sequenceName = "QUESTION_SEQ",		//실제 시퀀스 이름
		initialValue = 1,	//시퀀스 시작값
		allocationSize = 1	//시퀀스 증가치
		)
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "QUESTION_SEQ_GENERATOR")
	private Integer id;	//질문게시판의 글번호(기본키, 자동증가옵션)
	
	@Column(length = 200)
	private String subject; //질문게시판 제목과 내용
	
	@Column(length = 500)
	private String content;
	
	@CreatedDate
	private LocalDateTime createDate;
	
	//1:N 관계 -> 질문:답변들 -> OneToMany 
	//cascade -> 질문글(부모글)이 삭제될 경우 답변글(자식글)들도 함께 삭제되게 하는 설정
	@OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
	private List<Answer> answerList;
	
	//N:1 관계->질문:작성자
	@ManyToOne
	private SiteUser author; //글쓴이(1명)
	
	
	private LocalDateTime modifyDate;	//질문 글 수정 일시
}
