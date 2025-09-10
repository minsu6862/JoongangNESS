package com.minsu.msboard.question;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.minsu.msboard.DataNotFoundException;
import com.minsu.msboard.user.SiteUser;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuestionService {
	
	//@Autowired
	private final QuestionRepository questionRepository;
	//@RequiredArgsConstructor에 의해 생성자 방식으로 주입(final 필드만 가능)
	
	public List<Question>/*Page<Question>*/ getList(/* int page */) {	//모든 질문글 가져오기 -> 페이징되야함
		
		//Pageable pageable = PageRequest.of(page, 10);	//한페이지당 10개의 게시글 표시하기
		
		return questionRepository.findAll(/* pageable */);
	}
	
	public Question getQuestion(Integer id) {
		Optional<Question> qOptional = questionRepository.findById(id);
		
		if(qOptional.isPresent()) {
			return qOptional.get();
		} else {
			throw new DataNotFoundException("question not found");
		}
	}
	
	public void create(String subject, String content, SiteUser user) {
		Question question = new Question();
		question.setSubject(subject);
		question.setContent(content);
		question.setCreateDate(LocalDateTime.now());
		question.setAuthor(user);	//글쓴이 entity 추가
		
		questionRepository.save(question);
	}
	
	public void modify(Question question, String subject, String content) {
		question.setSubject(subject);	//새로운 제목으로 저장
		question.setContent(content);	//새로운 내용으로 저장
		question.setModifyDate(LocalDateTime.now());
		questionRepository.save(question);
	}
	
	//삭제기능
	public void delete(Question question) {
	    this.questionRepository.delete(question);
	}
}
