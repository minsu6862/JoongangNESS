package com.minsu.miniproject.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.minsu.miniproject.dao.MemberDao;

@Controller
public class MemberController {

	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping(value = "/index")
	public String index() {
		
		return "index";
	}
	
	@RequestMapping(value = "/join")
	public String join() {
		
		return "member/join";
	}
	
	@RequestMapping(value = "/joinOk")
	public String joinOk(HttpServletRequest request, Model model) {
		
		String memberId = request.getParameter("memberid");
		String memberPw = request.getParameter("memberpw");
		String memberName = request.getParameter("membername");
		
		MemberDao dao = sqlSession.getMapper(MemberDao.class);
		
		int idCheck = dao.memberIdCheck(memberId);
		
		if(idCheck == 1) { //가입하려는 아이디가 이미 존재->가입 불가
			model.addAttribute("msg", "이미 가입된 아이디 입니다. 다시 가입해 주세요.");
			
			return "member/join";
		} else {
			int result = dao.memberJoin(memberId, memberPw, memberName);
			System.out.println("가입성공여부 : " + result); //1이면 성공, 0이면 실패

			model.addAttribute("msg", memberName + "님 회원가입에 성공했습니다. 로그인을 시도해주세요.");
		    model.addAttribute("url", "login");
			
			return "alert/alert";
		}
	}
	
	@RequestMapping(value = "/login")
	public String login() {
		
		return "member/login";
	}
	
	@RequestMapping(value = "/loginOk")
	public String loginOk(HttpServletRequest request, Model model, HttpSession session) {
		
		String memberId = request.getParameter("memberid");
		String memberPw = request.getParameter("memberpw");
		
		MemberDao dao = sqlSession.getMapper(MemberDao.class);
		
		int checkFlag = dao.memberLogin(memberId, memberPw);
		
		if(checkFlag == 1) { //로그인하려는 아이디와 비번이 존재->성공
			String memberName = dao.getMemberName(memberId);
			
			session.setAttribute("sessionId", memberId); //로그인성공->세션 sessionId값 설정
			session.setAttribute("sessionName", memberName);
			
			return "index";
		} else { //로그인 실패		
			model.addAttribute("msg", "아이디 또는 비밀번호가 잘못 되었습니다.");
			
			return "member/login";		
		}
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
	    session.invalidate(); // 세션 무효화
	    return "redirect:/index";
	}
	
	@RequestMapping(value = "/infomap")
	public String infomap() {
		
		return "info/map";
	}
	
}
