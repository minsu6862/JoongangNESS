<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl 연습3</title>
</head>
<body>
	<!-- java for문 -->
	<%
	for (int i = 0; i < 10; i++) {	
		out.println(i + "<br>");
	}
	%>
	<br>
	
	<%
	for (int i = 0; i < 10; i += 2) {	
		out.println(i + "<br>");
	}
	%>
	<br>
	
	<%
	String[] strs = {"이순신", "김유신", "강감찬"};
	request.setAttribute("strs", strs);	//jstl에게 넣어주기 위한 코드
	
	for(int i = 0; i < strs.length; i++) {
		out.println(strs[i] + "<br>");
	}
	%>
	
	
	<!-- jstl for문 연습 -->
	<c:forEach var="i" begin="0" end="9">
		<h2>${i }</h2>
	</c:forEach>
	<br>
	
	<c:forEach var="i" begin="0" end="9" step="2">
		<h2>${i }</h2>
	</c:forEach>
	<br>
	
	<c:forEach var="str" items="${strs }">
		<h2>${str }</h2>
	</c:forEach>
</body>
</html>