package com.minsu.member.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.minsu.member.dao.MemberDao;

import jakarta.servlet.http.HttpServletRequest;


@Controller
public class MemberController {

	@Autowired
	public SqlSession sqlSession;
	
	@RequestMapping(value = "/joinOk")
	public String joinOk(HttpServletRequest request, Model model) {
		String mid = request.getParameter("id");
		String mpw = request.getParameter("pw");
		String mname = request.getParameter("name");
		
		MemberDao memberDao = sqlSession.getMapper(MemberDao.class);
		memberDao.joinMemberDao(mid, mpw, mname);
		
		return "joinOk";
	}
	
	@RequestMapping(value = "/testimg")
	public String imgtest() {
		return "testimg";
	}
	
}
