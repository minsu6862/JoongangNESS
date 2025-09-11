package com.minsu.msboard.question;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;
import com.minsu.msboard.SecurityConfig;
import com.minsu.msboard.SpringbootSbbProjectApplication;
import com.minsu.msboard.answer.AnswerForm;
import com.minsu.msboard.user.SiteUser;
import com.minsu.msboard.user.UserService;

import jakarta.validation.Valid;

@RequestMapping("/question")
@Controller
public class QuestionController {

    private final SecurityConfig securityConfig;

    private final SpringbootSbbProjectApplication springbootSbbProjectApplication;

//	@Autowired
//	private QuestionRepository questionRepository;
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private UserService userService;

    QuestionController(SpringbootSbbProjectApplication springbootSbbProjectApplication, SecurityConfig securityConfig) {
        this.springbootSbbProjectApplication = springbootSbbProjectApplication;
        this.securityConfig = securityConfig;
    }
	
	//페이징용 리스트
	@GetMapping(value = "/list")
	//@ResponseBody	//페이징 라이브러리에서는 기본이 되야하는 첫 페이지가 1이 아니라 0부터 시작
	public String list(Model model, @RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value="kw", defaultValue = "") String kw)  {
		
		//List<Question> questionList = questionRepository.findAll(); //모든 질문글 불러오기
		 //List<Question> questionList = questionService.getList();
		Page<Question> paging = questionService.getPageQuestions(page, kw);		
		//게시글 10개씩 자른 리스트->페이지당 10개->2페이지에 해당하는 글 10개 
		model.addAttribute("paging", paging);
		model.addAttribute("kw", kw);
		
		return "question_list";
	}
	
//	@GetMapping(value = "/list")
//	//@ResponseBody	//페이징 라이브러리에서는 기본이 되야하는 첫 페이지가 1이 아니라 0부터 시작
//	public String list(Model model) {
//		
//		//List<Question> questionList = questionRepository.findAll();
//		List<Question> questionList = questionService.getList();
//		model.addAttribute("paging", questionList);
//		
//		return "question_list";
//	}
	
	@GetMapping(value = "/detail/{id}") //파라미터 이름 없이 값만 넘어왔을때 처리하게끔 수행
	public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm) {
		
		
		//조회수 증가 메소드
		questionService.hit(questionService.getQuestion(id));
		
		//service에 2를 넣어서 호출
		Question question = questionService.getQuestion(id);
		model.addAttribute("question", question);
		
		return "question_detail";	//타임리프 html의 이름
	}
	
	@GetMapping(value = "/create")	//질문 등록 form만 띄워주는 메소드
	public String questionCreate(QuestionForm questionForm) {
		
		return "question_form";
	}
	
//	@PostMapping(value = "/create")	//질문 내용 작성 후 db에 저장하는 메소드
//	public String questionCreate2(@RequestParam(value = "subject") String subject, @RequestParam(value = "content") String content) {
//		//@RequestParam(value = "subject") String subject -> String subject = request.getParameter("subject")
//		
//		questionService.create(subject, content);	//질문 DB에 저장
//		
//		return "redirect:/question/list";	//반드시 redirect로
//	}
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping(value = "/create")	//질문 내용 작성 후 db에 저장하는 메소드
	public String questionCreate2(@Valid QuestionForm questionForm, BindingResult bindingResult, Principal principal) {
		
		if(bindingResult.hasErrors()) {	//참일 경우 -> 유효성 체크에서 에러 발생
			return "question_form";	//에러 발생시 다시 질문 등록 폼으로 이동
		}
		
		SiteUser siteUser = userService.getUser(principal.getName());
		
		questionService.create(questionForm.getSubject(), questionForm.getContent(), siteUser);	//질문 DB에 저장
		
		return "redirect:/question/list";	//반드시 redirect로
	}
	
	@PreAuthorize("isAuthenticated()")	//form에서 action으로 넘어오지 않으면 권한인증 안되는 오류가 발생함
	@GetMapping(value = "/modify/{id}")
	public String questionModify(QuestionForm questionForm, @PathVariable("id") Integer id, Principal principal) {
		Question question = questionService.getQuestion(id);	//id에 해당하는 엔티티가 반환 -> 수정하려는 글의 엔티티
		
		//글쓴 유저와 로그인한 유저의 동일 여부를 다시한번 확인
		if(!question.getAuthor().getUsername().equals(principal.getName())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정 권한이 없습니다");
		}
		
		//questionFomr에 subject와 content를 value값으로 출력하는 기능이 이미 구현되어 있으므로 해당 폼을 재활용하기 위해 일부러 실어보냄
		questionForm.setSubject(question.getSubject());
		questionForm.setContent(question.getContent());
		
		return "question_form";
	}
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping(value = "/modify/{id}")
	public String questionModify(@Valid QuestionForm questionForm, BindingResult bindingResult,
	                           @PathVariable("id") Integer id, Principal principal) {
	    
	    if (bindingResult.hasErrors()) {
	        return "question_form";
	    }
	    
	    Question question = questionService.getQuestion(id);
	    
	    // 수정 권한 확인
	    if (!question.getAuthor().getUsername().equals(principal.getName())) {
	        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정 권한이 없습니다");
	    }
	    
	    // 질문 수정
	    questionService.modify(question, questionForm.getSubject(), questionForm.getContent());
	    
	    return String.format("redirect:/question/detail/%s", id);
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping(value = "/delete/{id}")
	public String questionDelete(@Valid QuestionForm questionForm, BindingResult bindingResult,
            @PathVariable("id") Integer id, Principal principal) {
		
		Question question = questionService.getQuestion(id );
		
		// 삭제 권한 확인
	    if (!question.getAuthor().getUsername().equals(principal.getName())) {
	        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "삭제 권한이 없습니다");
	    }
	    
	    questionService.delete(question);
		
		return "redirect:/question/list";
	}
	
	//추천기능
	@PreAuthorize("isAuthenticated()")
	@GetMapping(value = "/vote/{id}")
	public String questionVote(@PathVariable("id") Integer id, Principal principal) {
		Question question = questionService.getQuestion(id);
		
		SiteUser siteUser = userService.getUser(principal.getName());
		
		questionService.vote(question, siteUser);
		
		return String.format("redirect:/question/detail/%s", id);
	}
	
	//비추천기능
	@PreAuthorize("isAuthenticated()")
	@GetMapping(value = "/disvote/{id}")
	public String questionDisVote(@PathVariable("id") Integer id, Principal principal) {
		Question question = questionService.getQuestion(id);
		
		SiteUser siteUser = userService.getUser(principal.getName());
		
		questionService.disvote(question, siteUser);
		
		return String.format("redirect:/question/detail/%s", id);
	}
	
}
