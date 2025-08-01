<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>request 세부사항</title>
</head>
<body>
	<%
	out.println("서버 : " + request.getServerName() + "<br>");
	out.println("포트번호 : " + request.getServerPort() + "<br>");
	out.println("요청 방식 : " + request.getMethod() + "<br>");
	out.println("프로토콜 : " + request.getProtocol() + "<br>");
	out.println("URL : " + request.getRequestURL() + "<br>");
	out.println("URI : " + request.getRequestURI() + "<br>");
	
	out.println("<hr>");
	
	out.println("클라이언트 정보 ip 주소: " + request.getRemoteAddr() + "<br>");
	out.println("클라이언트 정보 웹브라우저 : " + request.getHeader("User-Agent") + "<br>");
	
	%>
</body>
</html>