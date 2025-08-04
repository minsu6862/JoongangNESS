<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 확인</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
	
		String mid = request.getParameter("loginId");
		String mpw = request.getParameter("loginPw");
		
		if(mid.equals("tiger") && mpw.equals("12345")) { //참이면 로그인 성공
			session.setAttribute("sessionFlag", "yes");
			session.setAttribute("memberId", mid); //(세션 이름(작명), 세션에 저장할 로그인한 유저의 아이디 값)
			long current_loginTime = System.currentTimeMillis(); //현재 시간
			session.setAttribute("loginTime", current_loginTime); //로그인한 시간을 세션에 저장
			response.sendRedirect("loginSuccess.jsp"); //강제 페이지 이동->로그인성공 시 성공페이지로 이동
		} else {
			System.out.println("로그인 실패!!");
			response.sendRedirect("login.jsp"); //강제 페이지 이동->로그인실패 시 로그인 페이지로 다시 강제 이동
			session.setAttribute("loginTime", 0); //로그인한 시간을 세션에 저장
		}
	
	%>
</body>
</html>