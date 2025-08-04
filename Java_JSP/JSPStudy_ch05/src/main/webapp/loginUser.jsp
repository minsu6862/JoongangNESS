<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인한 유저 페이지</title>
</head>
<body>
	<%
	String sid = (String) session.getAttribute("memberId");
	
	if (sid != null) {	//참이면 로그인 상태, 거짓이면 로그인하지 않은 상태
		out.println("이 글은 로그인한 상태에만 보이는 글입니다.");
	} else {
		out.println("이 글은 로그인 하지 않은 상태에서만 보이는 글입니다.");
	}
	%>
</body>
</html>