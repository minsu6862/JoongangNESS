package com.minsu.msboard.question;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

	public Question findBySubject(String subject);	//subject -> 테이블에 존재해야하는 필드 이름
	//Select * from Question Where subject = ?
	
	public Question findBySubjectAndContent(String subject, String content);
	//Select * from Question Where subject = ? AND content = ?
	
	public List<Question> findBySubjectLike(String keyword);	//특정 단어가 포함된 제목의 레코드 반환
	//Select * from Question Where subject LIKE  %?%
	
	//TODO:public Page<Question> findAll(Pageable pageable);
	
//	@Query(value = "UPDATE question SET hit=hit + 1 WHERE id = :id", nativeQuery = true)
//	public void updateHit(@Param("id") Integer id);	//기본글의 기본키 번호로 조회수 증가
	
}
