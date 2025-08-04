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
		request.setCharacterEncoding("utf-8");
	
		String mid = request.getParameter("loginId");
		String mpw = request.getParameter("loginPw");
		
		
		
		if(mid.equals("tiger") && mpw.equals("12345")) {
			session.setAttribute("memberId", mid); //세션에 memberId 값 저장
			response.sendRedirect("index.jsp"); //index.jsp로 강제 이동
		} else {
			response.sendRedirect("login.jsp"); //login.jsp로 강제 이동
		}
	
	%>
</body>
</html>