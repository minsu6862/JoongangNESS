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
	String mid, mpw;
	%>
	<%
	request.setCharacterEncoding("UTF-8");
		
	mid = request.getParameter("loginId");
	mpw = request.getParameter("loginPw");
	
	if(mid.equals("tiger") && mpw.equals("1234")) {
		session.setAttribute("sid", mid);	//세션 아이디값 저장, 로그인성공
		Cookie cookie1 = new Cookie("cid", mid);	//쿠키를 생성
		response.addCookie(cookie1);	//생성한 쿠키를 클라이언트에게 전송
		Cookie cookie2 = new Cookie("cpw", mpw);	//쿠키를 생성
		response.addCookie(cookie2);	//생성한 쿠키를 클라이언트에게 전송
		response.sendRedirect("welcome.jsp");
	} else {
		response.sendRedirect("login.jsp");
	}
	%>
</body>
</html>