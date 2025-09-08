package com.minsu.msboard.question;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.validation.Valid;

@RequestMapping("/question")
@Controller
public class QuestionController {

//	@Autowired
//	private QuestionRepository questionRepository;
	
	@Autowired
	private QuestionService questionService;
	
	@GetMapping(value = "/")
	public String root() {
		
		return "redirect:/list";
	}
	
	@GetMapping(value = "/list")
	//@ResponseBody
	public String list(Model model) {
		
		//List<Question> questionList = questionRepository.findAll();
		List<Question> questionList = questionService.getList();
		model.addAttribute("questionList", questionList);
		
		return "question_List";
	}
	
	@GetMapping(value = "/detail/{id}") //파라미터 이름 없이 값만 넘어왔을때 처리하게끔 수행
	public String detail(Model model, @PathVariable("id") Integer id) {
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
	
	@PostMapping(value = "/create")	//질문 내용 작성 후 db에 저장하는 메소드
	public String questionCreate2(@Valid QuestionForm questionForm, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {	//참일 경우 -> 유효성 체크에서 에러 발생
			return "question_form";	//에러 발생시 다시 질문 등록 폼으로 이동
		}
		
		questionService.create(questionForm.getSubject(), questionForm.getContent());	//질문 DB에 저장
		
		return "redirect:/question/list";	//반드시 redirect로
	}
	
}
