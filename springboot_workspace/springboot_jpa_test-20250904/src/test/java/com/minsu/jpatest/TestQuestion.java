package com.minsu.jpatest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.minsu.jpatest.dto.QuestionDto;
import com.minsu.jpatest.entity.Questiontbl;
import com.minsu.jpatest.repository.QuestionRepository;

@SpringBootTest
public class TestQuestion {

	@Autowired
	private QuestionRepository questionRepository;

	/*
	 * @Test
	 * 
	 * @DisplayName("질문 등록 테스트") public void writeQuestion() {
	 * 
	 * Questiontbl question = new Questiontbl();
	 * 
	 * question.setQtitle("첫번째 질문입니다"); question.setQcontent("오늘은 목요일이 맞나요?");
	 * 
	 * QuestionDto questionDto = new QuestionDto();
	 * questionDto.setQtitle("세번째 질문입니다."); questionDto.setQcontent("내일부터 주말입니다.");
	 * 
	 * 
	 * questionRepository.save(questionDto.getEntity()); }
	 */

//	@Test
//	@DisplayName("질문 삭제 테스트")
//	public void deleteQuestion() {
//		
//		//questionRepository.deleteAll(); //모든 데이터 삭제->주의!
//		
//		//questionRepository.deleteById(3);
//		//기본키 qnum=3 인 레코드를 찾아서 삭제
//		
////		List<Questiontbl> quList = new ArrayList<>();		
////		
////		questionRepository.deleteAll(quList); //entity 리스트 삭제(원하는 레코드들만 삭제)
//		
//		questionRepository.deleteAllByQtitle("홍길동"); //질문 제목으로 찾아서 삭제
//	}
	
	@Test
	@DisplayName("질문 조회 리스트")
	public void searchQuestion() {
		
		//findAll() -> 모든 레코드 가져오기 select * from table
		List<Questiontbl> questionAllList = questionRepository.findAll();
		
		for(Questiontbl question : questionAllList) {
			System.out.println(question.getQnum());
			System.out.println(question.getQtitle());
			System.out.println(question.getQcontent());
			System.out.println(question.getQdate());
			System.out.println("========================");
		}
		
		//findAll() -> 모든 레코드 가져오기 select * from table
		List<Questiontbl> questionOrderList = questionRepository.findAllByOrderByQdateDesc();
		
		for(Questiontbl question : questionOrderList) {
			System.out.println(question.getQnum());
			System.out.println(question.getQtitle());
			System.out.println(question.getQcontent());
			System.out.println(question.getQdate());
			System.out.println("========================");
		}
	}

	@Test
	@DisplayName("특정 질문 검색")
	public void searchQuestionByField() {
		Optional<Questiontbl> questionOption = questionRepository.findById(4); //기본키로 검색
		//select * from jpaquestiontbl where qnum=4
		
		//기본키로 검색했을 경우 레코드가 1개 또는 존재하지 않는 경우 발생
		//Option<Questiontbl> 형태로 반환 타입을 정해야 한다
		//isPresent() 를 활요하면 Option<Questiontbl> 내에 객체의 존재여부를 알수가 있다.
		if(questionOption.isPresent()) { //참이면 해당 기본키를 가진 레코드가 존재->조회 OK 
			Questiontbl question = questionOption.get(); //해당 기본키를 가진 엔티티(레코드)가 반환
			System.out.println(question.getQnum());
			System.out.println(question.getQtitle());
		} else { //해당 기본키를 가진 레코드가 존재 X->조회실패
			System.out.println("해당 번호의 질문은 존재하지 않습니다.");
		}
		
		//select * from jpaquestiontbl where qnum=1 and qtitle=홍길동
		Questiontbl question1 = questionRepository.findByQnumAndQtitle(8, "홍길동");
		System.out.println("글번호가 8번이고 글제목이 홍길동인 레코드 :"+question1.getQnum());
		
		
		//질문 제목이 정확히 일치하는 조건으로 조회
		List<Questiontbl> questions = questionRepository.findAllByQtitle("홍길동");
		
		for(Questiontbl question:questions) {
			System.out.println(question.getQtitle());
		}
		
		//질문 제목에 특정 문자가 들어 있으면 찾는 조건으로 조회->like
		List<Questiontbl> likeQuestions = questionRepository.findAllByQtitleLikeOrderByQdateDesc("%질문%");
		for(Questiontbl question:likeQuestions) {
			System.out.println(question.getQnum());
			System.out.println(question.getQtitle());
			System.out.println("-------------------------");
		}
		
		//직접 쓴 SQL문(@Query 사용)으로 조회
		Questiontbl questionSql = questionRepository.findQuestionByQnum(3);
		System.out.println(questionSql.getQnum());
		System.out.println(questionSql.getQtitle());
	}
	
	@Test
	@DisplayName("특정 질문 내용 업데이트")
	public void updateQuestion() {
		int updateResult = questionRepository.updateQcontentByQnum("질문을 변경하셨습니다", 4);
		
		Optional<Questiontbl> questionOptional = questionRepository.findById(4);
		
		if(questionOptional.isPresent()) {
			Questiontbl question = questionOptional.get();
			System.out.println(question.getQnum());
			System.out.println(question.getQcontent());
		} else {
			System.out.println("조회되지 않는 질문입니다.");
		}
	}
	
}
