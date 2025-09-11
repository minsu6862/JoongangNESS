package com.minsu.msboard.question;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.minsu.msboard.DataNotFoundException;
import com.minsu.msboard.answer.Answer;
import com.minsu.msboard.user.SiteUser;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
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
	
	//리스트를 페이징하여 조회
	public Page<Question> getPageQuestions(int page, String kw) {
			
		//Specification<Question> spec = search(kw);
			
		int size = 10; //1페이지당 10개씩 글 출력
		
		int startRow = page * size; //첫 페이지 page=0 -> 0*10 -> 0, 두번째 페이지 page=1 -> 10
		int endRow = startRow + size; //0+10 -> 10, 두번째 페이지 10 + 10 = 20
		//검색어 없이 리스트 조회
		//List<Question> pageQuestionList = questionRepository.findQuestionsWithPaging(startRow, endRow);
		//long totalQuestion = questionRepository.count(); //모든 글 갯수 가져오기
				
		//검색어로 검색 결과 리스트 조회		
		List<Question> searchQuestionList = questionRepository.searchQuestionsWithPaging(kw, startRow, endRow);
//		int totalSearchQuestion = searchQuestionList.size(); //검색된 총 질문글 수
		//long totalQuestion = questionRepository.count(); //모든 글 갯수 가져오기
		int totalSearchQuestion = questionRepository.countSearchResult(kw);
		
		//Page<Question> pagingList = new PageImpl<>(pageQuestionList, PageRequest.of(page, size), totalQuestion);
		Page<Question> pagingList = new PageImpl<>(searchQuestionList, PageRequest.of(page, size), totalSearchQuestion);

		return pagingList;
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
	
	//추천
	public void vote(Question question, SiteUser siteUser) {	//조회수랑 같은 매커니즘, update문
		question.getVoter().add(siteUser);
		//question -> 추천을 받은 글의 번호로 조회한 질문 entity
		//question의 멤버인 voter를 getVoter해서 voter에 추천을 누른 유저의 entity를 추가
		questionRepository.save(question);	//추천한 유저수가 변경된 질문엔티티를 다시 save해서 갱신
		
	}
	
	//비추천
	public void disvote(Question question, SiteUser siteUser) {	//조회수랑 같은 매커니즘, update문
		question.getDisvoter().add(siteUser);
		//question -> 추천을 받은 글의 번호로 조회한 질문 entity
		//question의 멤버인 voter를 getVoter해서 voter에 추천을 누른 유저의 entity를 추가
		questionRepository.save(question);	//추천한 유저수가 변경된 질문엔티티를 다시 save해서 갱신
		
	}
	
	//조회수 기능
	public void hit(Question question) {
		question.setHit(question.getHit() + 1);
		
		questionRepository.save(question);
	}
	
	//검색기능
	private Specification<Question> search(String kw) { //키워드(kw) 검색 조회
		
		return new Specification<Question>() {
			private static final long SerialVersionUID = 1L;
			
			@Override
			public Predicate toPredicate(Root<Question> q, CriteriaQuery<?> query, CriteriaBuilder cb) {
				
				query.distinct(true); //distinct->중복 제거
				Join<Question, SiteUser> u1 = q.join("author", JoinType.LEFT); //question + siteUser left 조인
				Join<Question, Answer> a = q.join("answerList", JoinType.LEFT); //question + answer left 조인
				Join<Answer, SiteUser> u2 = a.join("author", JoinType.LEFT); //answer + siteUser left 조인
				
				return cb.or(cb.like(q.get("subject"), "%" + kw + "%"),//질문 제목에서 검색어 조회
						cb.like(q.get("content"), "%" + kw + "%"), //질문 내용에서 검색어 조회
						cb.like(u1.get("username"), "%" + kw + "%"), //질문 작성자에서 검색어 조회
						cb.like(a.get("content"), "%" + kw + "%"), //답변 내용에서 검색어 조회
						cb.like(u2.get("username"), "%" + kw + "%") //답변 작성자에서 검색어 조회
						) 
				;
			}
		};
	}
}
