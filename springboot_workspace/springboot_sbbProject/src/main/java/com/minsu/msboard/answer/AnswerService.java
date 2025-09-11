package com.minsu.msboard.answer;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minsu.msboard.DataNotFoundException;
import com.minsu.msboard.question.Question;
import com.minsu.msboard.user.SiteUser;

@Service
public class AnswerService {

	@Autowired
	private AnswerRepository answerRepository;
	
	public Answer create(Question question, String content, SiteUser author) {
		Answer answer = new Answer();
		answer.setContent(content);
		answer.setCreateDate(LocalDateTime.now()); //현재 시간 등록(답변 등록 시간)
		answer.setQuestion(question);
		answer.setAuthor(author);
		answerRepository.save(answer);
		
		return answer;	//db에 등록한 답변 바로 반환
	}
	
	public Answer getAnswer(Integer id) {	//기본키인 답변 id를 인수로 넣어주면 해당 엔티티 반환
		Optional<Answer> _answer = answerRepository.findById(id);	//기본키로 엔티티 조회
		
		if(_answer.isPresent()) {
			return _answer.get();
		} else {
			throw new DataNotFoundException("해당 답변이 존재하지 않습니다.");
		}
	}
	
	public void modify(Answer answer, String content) {
		answer.setContent(content);
		answer.setModifyDate(LocalDateTime.now());
		answerRepository.save(answer);
	}
	
	public void delete(Answer answer) { //답변 삭제하기
		answerRepository.delete(answer);
	}
	
	//추천
	public void vote(Answer answer, SiteUser siteUser) {	//조회수랑 같은 매커니즘, update문
		answer.getVoter().add(siteUser);
		//answer -> 추천을 받은 글의 번호로 조회한 질문 entity
		//answer의 멤버인 voter를 getVoter해서 voter에 추천을 누른 유저의 entity를 추가
		answerRepository.save(answer);	//추천한 유저수가 변경된 질문엔티티를 다시 save해서 갱신
		
	}
	
	//비추천
	public void disvote(Answer answer, SiteUser siteUser) {	//조회수랑 같은 매커니즘, update문
		answer.getDisvoter().add(siteUser);
		//question -> 추천을 받은 글의 번호로 조회한 질문 entity
		//question의 멤버인 voter를 getVoter해서 voter에 추천을 누른 유저의 entity를 추가
		answerRepository.save(answer);	//추천한 유저수가 변경된 질문엔티티를 다시 save해서 갱신
		
	}
}
