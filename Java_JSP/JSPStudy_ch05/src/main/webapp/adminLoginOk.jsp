<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
  		String adminId = request.getParameter("adminId");
		String adminPw = request.getParameter("adminPw");
	%>
</body>
	<%
	if(adminId.equals("admin") || adminPw.equals("1234")) {
	%>
	안녕하세요 관리자님, 로그인 성공하셨습니다.
	<%
	} else {
	%>
	로그인 실패하셨습니다.
	<%
	}
	%>
</html>