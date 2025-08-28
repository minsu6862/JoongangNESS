package com.minsu.number.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.minsu.number.dao.MemberDao;
import com.minsu.number.dto.MemberDto;

@Controller
public class MemberController {

	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@RequestMapping(value = "/join")
	public String join() {
		
		return "join";
	}
	
	@RequestMapping(value = "/search")
	public String search() {
		
		return "searchMember";
	}
	
	@RequestMapping(value = "/searchOk")
	public String searchOk(HttpServletRequest request, Model model) {
		
		MemberDto memberDto = memberDao.searchMember(request.getParameter("member_id"));
		model.addAttribute("memberDto", memberDto);
		model.addAttribute("result", "1");
		return "searchMember";
	}
	
	@RequestMapping(value = "/joinOk")
	public String joinOk(HttpServletRequest request, Model model) {
		String member_id = request.getParameter("member_id");
		String member_pw = request.getParameter("member_pw");
		String member_name = request.getParameter("member_name");
		int member_age = Integer.parseInt(request.getParameter("member_age"));
		
		/*
		 * MemberDao memberDao = new MemberDao(); memberDao.insertMember(member_id,
		 * member_pw, member_name, member_age);
		 */
		memberDao.insertMember(member_id, member_pw, member_name, member_age);
		
		return "redirect:memberlist";
	}
	
	@RequestMapping(value = "/memberlist")
	public String memberlist(HttpServletRequest request, Model model) {
		List<MemberDto> memberDto =  memberDao.searchMembers();
		model.addAttribute("memberDto", memberDto);
		
		return "memberlist";
	}
}
