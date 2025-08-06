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
		
	mid = request.getParameter("mid");
	mpw = request.getParameter("mpw");
	
	request.setAttribute("memberPw", mpw);
	
	if(mid.equals("tiger") && mpw.equals("1234")) {
		session.setAttribute("user", mid);	//세션 아이디값 저장, 로그인성공
	}
	%>
	
	<h2>${ sessionScope.user }님 로그인을 환영합니다</h2>
	<h3>입력하신 비밀번호는 <%= mpw %>입니다.</h3>
	<h3>입력하신 비밀번호는 ${ memberPw }입니다.</h3>
</body>
</html>