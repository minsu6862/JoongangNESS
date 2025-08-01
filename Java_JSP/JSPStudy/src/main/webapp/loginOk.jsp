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
  		String memberId = request.getParameter("loginId");
		String memberPw = request.getParameter("loginPw");
	%>
	<h2>로그인하신 아이디는 <b><i><%= memberId %></i></b>이고, 비밀번호는 <%= memberPw %>입니다.</h2>
</body>
</html>