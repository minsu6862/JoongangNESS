package com.minsu.msboard;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.minsu.msboard.question.Question;
import com.minsu.msboard.question.QuestionRepository;

@SpringBootTest
public class Test01 {

	@Autowired
	private QuestionRepository questionRepository;
	
//	@Test
//	@DisplayName("questuon 테이블에 질문글 저장하기")
//	public void testJpa1() {
//		Question q1 = new Question();
//		q1.setSubject("sbb가 무엇인가요?");	//질문글 제목
//		q1.setContent("sbb에 대해 알고 싶습니다");	//질문내용
//		q1.setCreateDate(LocalDateTime.now());	//현재시간 넣기
//		
//		questionRepository.save(q1);
//		
//		Question q2 = new Question();
//		q2.setSubject("springboot model이 무엇인가요?");	//질문글 제목
//		q2.setContent("아이디는 자동 생성되는것이 맞나요");	//질문내용
//		q2.setCreateDate(LocalDateTime.now());	//현재시간 넣기
//		
//		questionRepository.save(q2);
//	}
	
	@Test
	@DisplayName("모든 질문글 조회하기 테스트")
	public void testJpa2() {
		List<Question> allQuestion = questionRepository.findAll();	//모든 질문글 조회하기
		
		assertEquals(2, allQuestion.size());	//예상 결과 조회하기(기대값, 실제값)테스트해보는것
		
		Question question = allQuestion.get(0);
		assertEquals("sbb가 무엇인가요?", question.getSubject());
	}
	
	@Test
	@DisplayName("질문글 id로 조회하기 테스트")
	public void testJpa3() {
		Optional<Question> qOptional = questionRepository.findById(1);	//기본키로 조회하기 -> 1번글
		
		if(qOptional.isPresent()) {	//참이면 기본키 번호가 존재
			Question question = qOptional.get();	//글 꺼내기
			assertEquals("sbb가 무엇인가요?", question.getSubject());
		}
	}
	
	@Test
	@DisplayName("질문글 제목으로 조회하기 테스트")
	public void testJpa4() {
		Question question = questionRepository.findBySubject("sbb가 무엇인가요?");	//기본키로 조회하기 -> 1번글
		
		assertEquals(1, question.getId());
	}
	
	@Test
	@DisplayName("질문글 제목과 내용으로 조회하기 테스트")
	public void testJpa5() {
		Question question = questionRepository.findBySubjectAndContent("sbb가 무엇인가요?", "sbb에 대해 알고 싶습니다");	//기본키로 조회하기 -> 1번글
		//Select * from Question Where subject = "sbb가 무엇인가요?" AND content = "sbb에 대해 알고 싶습니다"
		assertEquals(1, question.getId());
	}
	
	@Test
	@DisplayName("제목에 특정 단어가 들어간 레코드 조회한 글 테스트")
	public void testJpa6() {
		List<Question> questionList = questionRepository.findBySubjectLike("%sbb%");	//기본키로 조회하기 -> 1번글
		
		Question question = questionList.get(0);
		assertEquals("sbb가 무엇인가요?", question.getSubject());
	}
}
