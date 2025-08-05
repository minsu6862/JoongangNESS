<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그 아웃</title>
</head>
<body>
	<%
		session.invalidate(); //세션 모두 삭제->로그 아웃		
	%>
	로그 아웃 하셨습니다.<br>
	<a href="login.jsp">로그인 바로가기</a>
</body>
</html>