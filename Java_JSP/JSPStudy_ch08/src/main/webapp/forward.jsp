<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forward 연습</title>
</head>
<body>	
	<h2>저는 forward.jsp 입니다!</h2> <!-- 클라이언트 화면에 보이지 않음 -->
	<%
		//response.sendRedirect("forward_sub.jsp");
	%>
	<!-- 강제 이동 -->
	<jsp:forward page="forward_sub.jsp" />
</body>
</html>