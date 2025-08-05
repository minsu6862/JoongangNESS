<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forward paramOk 페이지</title>
</head>
<body>	
	<%
		request.setCharacterEncoding("utf-8");
	
		String mid = request.getParameter("id");
		String mpw = request.getParameter("pw");
	%>
	
	로그인한 아이디 : <%= mid %><br><br>
	로그인한 비밀번호 : <%= mpw %>
	
	
</body>
</html>