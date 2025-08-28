package com.minsu.board.command;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface BoardCommand {
	
	public void execute(HttpServletRequest request, Model model);
}
