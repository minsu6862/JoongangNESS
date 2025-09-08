package com.minsu.msboard.question;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

	public Question findBySubject(String subject);	//subject -> 테이블에 존재해야하는 필드 이름
	//Select * from Question Where subject = ?
	
	public Question findBySubjectAndContent(String subject, String content);
	//Select * from Question Where subject = ? AND content = ?
	
	public List<Question> findBySubjectLike(String keyword);	//특정 단어가 포함된 제목의 레코드 반환
	//Select * from Question Where subject LIKE  %?%
}
