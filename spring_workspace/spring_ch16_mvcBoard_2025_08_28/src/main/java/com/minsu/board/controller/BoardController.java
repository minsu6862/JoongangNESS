package com.minsu.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.minsu.board.command.BoardCommand;
import com.minsu.board.command.BoardContentViewCommand;
import com.minsu.board.command.BoardListCommand;
import com.minsu.board.command.BoardWriteCommand;
import com.minsu.board.dao.BoardDao;
import com.minsu.board.dto.BoardDto;

@Controller
public class BoardController {
	
	BoardCommand command = null;
	
	@RequestMapping(value = "/write_form")	//글쓰기 양식을 출력하는 요청 처리
	public String write_form() {
		
		return "writeForm";
	}
	
	@RequestMapping(value = "/write")	//유저가 쓴 글을 db에 삽입하는 요청 처리
	public String write(HttpServletRequest request, Model model) {
		command = new BoardWriteCommand();
		command.execute(request, model);
		
		return "redirect:/boardlist";
	}
	
	@RequestMapping(value = "/boardlist")
	public String boardList(HttpServletRequest request, Model model) {
		command = new BoardListCommand();
		command.execute(request, model);
		
		return "boardlist";
	}
	
	@RequestMapping(value = "/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		command = new BoardContentViewCommand();
		command.execute(request, model);
		
		return "contentView";
	}
}
