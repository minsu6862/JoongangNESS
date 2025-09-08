package com.minsu.msboard.answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.minsu.msboard.question.Question;
import com.minsu.msboard.question.QuestionService;

@RequestMapping("/answer")
@Controller
public class AnswerController {
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private AnswerService answerService;
	
	@PostMapping(value = "/create/{id}")
	public String createAnswer(Model model, @PathVariable("id") Integer id, @RequestParam("content") String content) {
		Question question = questionService.getQuestion(id);		
		
		answerService.create(question, content); //DB에 답변 등록
		
		return String.format("redirect:/question/detail/%s", id);
	}
}
