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
	
//	@Query(value = "UPDATE question SET hit=hit + 1 WHERE id = :id", nativeQuery = true)
//	public void updateHit(@Param("id") Integer id);	//기본글의 기본키 번호로 조회수 증가
	
	//페이징 쿼리
	//TODO:public Page<Question> findAll(Pageable pageable);
	@Query(
	         value = "SELECT * FROM ( " +
	                 " SELECT q.*, ROWNUM rnum FROM ( " +
	                 "   SELECT * FROM question ORDER BY create_date DESC " +
	                 " ) q WHERE ROWNUM <= :endRow " +
	                 ") WHERE rnum > :startRow",
	         nativeQuery = true)
	    List<Question> findQuestionsWithPaging(@Param("startRow") int startRow,
	                                           @Param("endRow") int endRow);
	
	// 검색 페이징 - 컬럼명 수정
    @Query(value =
        "SELECT * FROM ( " +
        "    SELECT q.*, ROWNUM rnum FROM ( " +
        "        SELECT DISTINCT q.* " +
        "        FROM question q " +
        "        LEFT OUTER JOIN siteuser u1 ON q.author_id = u1.id " +
        "        LEFT OUTER JOIN answer a ON a.question_id = q.id " +
        "        LEFT OUTER JOIN siteuser u2 ON a.author_id = u2.id " +
        "        WHERE q.subject LIKE '%' || :kw || '%' " +
        "           OR q.content LIKE '%' || :kw || '%' " +
        "           OR u1.username LIKE '%' || :kw || '%' " +
        "           OR a.content LIKE '%' || :kw || '%' " +
        "           OR u2.username LIKE '%' || :kw || '%' " +
        "        ORDER BY q.create_date DESC " +  // createdate -> create_date
        "    ) q WHERE ROWNUM <= :endRow " +
        ") WHERE rnum > :startRow",
        nativeQuery = true)
    List<Question> searchQuestionsWithPaging(@Param("kw") String kw, 
                                           @Param("startRow") int startRow,
                                           @Param("endRow") int endRow);

    // 검색 결과 총 갯수 반환
    @Query(value =
        "SELECT COUNT(DISTINCT q.id) " +
        "FROM question q " +
        "LEFT OUTER JOIN siteuser u1 ON q.author_id = u1.id " +
        "LEFT OUTER JOIN answer a ON a.question_id = q.id " +
        "LEFT OUTER JOIN siteuser u2 ON a.author_id = u2.id " +
        "WHERE q.subject LIKE '%' || :kw || '%' " +
        "   OR q.content LIKE '%' || :kw || '%' " +
        "   OR u1.username LIKE '%' || :kw || '%' " +
        "   OR a.content LIKE '%' || :kw || '%' " +
        "   OR u2.username LIKE '%' || :kw || '%' ",
        nativeQuery = true)
    public int countSearchResult(@Param("kw") String kw);
}
