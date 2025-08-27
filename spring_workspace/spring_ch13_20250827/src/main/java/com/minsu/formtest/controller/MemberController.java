package com.minsu.formtest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {
	
	@RequestMapping(value = "/login")
	public String login() {
		
		return "login";
	}
	
	@RequestMapping(value = "/join")
	public String join() {
		
		return "join";
	}
	
	@RequestMapping(value = "/loginOk")
	public String loginOk(HttpServletRequest request, Model model, HttpSession session, HttpServletResponse response) {
		
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		
		model.addAttribute("mid", mid);
		model.addAttribute("mid", mid);
		
		if(mid.equals("tiger") && mpw.equals("12345")) {
			session.setAttribute("sessionId", mid);
			
			return "loginOk";
		} else {
			return "loginFail";
		}
		
	}
	
	@RequestMapping(value = "/loginOk2")
	public String loginOk2(@RequestParam("mid") String mid, @RequestParam("mpw") String mpw,  Model model, HttpSession session, HttpServletResponse response) {
		
//		String mid = request.getParameter("mid"); //클라이언트가 입력한 아이디값 불러오기
//		String mpw = request.getParameter("mpw"); //클라이언트가 입력한 비밀번호값 불러오기
		
		model.addAttribute("mid", mid);
		if(mid.equals("tiger") && mpw.equals("12345")) { //참이면 로그인 성공
			session.setAttribute("sessionId", mid); //세션에 로그인한 아이디 올리기		
			return "loginOk";
		} else { //로그인 실패
		
			return "loginFail";
		}
	}
	
	@RequestMapping(value = "/boardlist/{bnum}") //넘어오는 파라미터가 한두개면 나쁘지않은 방법
	public String boardlist(@PathVariable String bnum, Model model) {
		model.addAttribute("bnum", bnum);
		
		return "loginFail";
	}
	
	/* //방법1 제일 심플하지만 적당히 긴 코드
	 * @RequestMapping(value = "/joinOk") public String joinOk(HttpServletRequest
	 * request, Model model) {
	 * 
	 * String memberId = request.getParameter("memberId"); String memberPw =
	 * request.getParameter("memberPw"); String memberName =
	 * request.getParameter("memberName"); String memberAge =
	 * request.getParameter("memberAge");
	 * 
	 * MemberDto memberDto = new MemberDto(memberId, memberPw, memberName,
	 * memberAge);
	 * 
	 * model.addAttribute("memberDto", memberDto);
	 * 
	 * return "joinOk"; }
	 */
	
	/*//방법2 파라미터가 여러개일 경우 매우 길어지기에 비추
	 * @RequestMapping(value = "/joinOk") public String
	 * joinOk(@RequestParam("memberId") String memberId, @RequestParam("memberPw")
	 * String memberPw, @RequestParam("memberName") String
	 * memberName, @RequestParam("memberAge") String memberAge, Model model) {
	 * 
	 * MemberDto memberDto = new MemberDto(memberId, memberPw, memberName,
	 * memberAge);
	 * 
	 * model.addAttribute("memberDto", memberDto);
	 * 
	 * return "joinOk"; }
	 */
	
	/*
	 * //방법3 제일짧고 편리하지만 조건이 있음
	 * 
	 * @RequestMapping(value = "/joinOk") //조건 - MemberDto의 멤버변수와 넘어오는 Form의
	 * parameter이름이 일치해야함 public String joinOk(MemberDto memberDto, Model model) {
	 * 
	 * model.addAttribute("memberDto", memberDto);
	 * 
	 * return "joinOk"; }
	 */
	
	//method는 생략(원래는 명시하는게 맞음)하면 둘 다 알잘딱 받는데, 보내기는 post로 보내고 컨트롤러에서 get방식으로 받겠다고 조건을 걸면 에러남
	@RequestMapping(value = "/joinOk", method = RequestMethod.POST)	//조건 - MemberDto의 멤버변수와 넘어오는 Form의 parameter이름이 일치해야함
	public String joinOk1(MemberDto memberDto, Model model) {
		
		model.addAttribute("memberDto", memberDto);
		
		return "joinOk";
	}
	
	//위의 메소드만 있을 경우 post는 정상작동하고 get은 에러가 나야 하지만 이렇게 두개를 만들면 메소드를 구문해서 작동하기에 에러나지않음 - 두가지 방식 다 처리 가능 
	@RequestMapping(value = "/joinOk", method = RequestMethod.GET)	//조건 - MemberDto의 멤버변수와 넘어오는 Form의 parameter이름이 일치해야함
	public String joinOk2(MemberDto memberDto, Model model) {
		
		model.addAttribute("memberDto", memberDto);
		
		return "joinOk";
	}
	
	//밑에 model로 객체를 전달하는 코드를 줄일수도 있고, 매개변수 이름이 길 경우 이것도 요약해서 쓸 수 있어서 편리
	@RequestMapping(value = "/studentOk")
	public String studentInfo(@ModelAttribute("stuInfo") StudentInfoDto studentInfoDto, Model model) {
		
		//model.addAttribute("studentInfoDto", studentInfoDto);
		
		return "studentOk";
	}
}
