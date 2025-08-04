<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃->모든 세션 삭제</title>
</head>
<body>
	<%
	
		session.invalidate(); //모든 세션 삭제
	
	%>
	
	<a href="sessionInfo.jsp">세션 정보 보기 바로가기</a>
</body>
</html>