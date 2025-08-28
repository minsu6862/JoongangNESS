package com.minsu.board.command;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.minsu.board.dao.BoardDao;

public class BoardWriteCommand implements BoardCommand {
	
	@Override
	public void execute(HttpServletRequest request, Model model) {
		BoardDao boardDao = new BoardDao();
		boardDao.write(request.getParameter("board_name"), request.getParameter("board_title"), request.getParameter("board_content"));
		
	}
}
