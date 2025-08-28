package com.minsu.board.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import com.minsu.board.dao.BoardDao;
import com.minsu.board.dto.BoardDto;

public class BoardListCommand implements BoardCommand {
	
	@Override
	public void execute(HttpServletRequest request, Model model) {
		BoardDao boardDao = new BoardDao();
		List<BoardDto> boardDtos = boardDao.boardlist();
		model.addAttribute("boardDtos", boardDtos);
	}
}
