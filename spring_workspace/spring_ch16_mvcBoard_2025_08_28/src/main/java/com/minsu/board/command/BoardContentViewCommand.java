package com.minsu.board.command;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.minsu.board.dao.BoardDao;
import com.minsu.board.dto.BoardDto;

public class BoardContentViewCommand implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, Model model) {
		String board_num = request.getParameter("board_num");
		BoardDao boardDao = new BoardDao();
		BoardDto boardDto = boardDao.contentView(board_num);
		
		model.addAttribute("boardDto", boardDto);

	}

}
