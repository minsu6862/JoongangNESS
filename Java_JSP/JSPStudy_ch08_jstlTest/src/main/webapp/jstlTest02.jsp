<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 연습2</title>
</head>
<body>
	<h1>자바 사용</h1>
	<%
	if(10 > 5) {
	%>
	<h2>10은 5보다 크다 = 참입니다.</h2>
	<%	
	} else {
	%>
	<h2>10은 5보다 작다 = 틀렸습니다.</h2>
	<%
	}
	%>
	<%
	int score = 85;
	
	if(score >= 90) {
	%>
	<h2>수</h2>
	<%	
	} else if(score>=80) {
	%>
	<h2>우</h2>
	<%	
	} else if(score>=70) {
	%>
	<h2>미</h2>
	<%	
	} else if(score>=60) {
	%>
	<h2>미</h2>
	<%	
	} else if(score>=50) {
	%>
	<h2>양</h2>
	<%	
	} else {
	%>
	<h2>가</h2>
	<%	
	}
	%>
	
	<hr>
	<h1>JSTL 사용</h1>
	<!-- JSTL if문 -->
	<c:if test="${ 10 > 5 }">
	<h2>10은 5보다 크다 = 참입니다.</h2>
	</c:if>
	
	<!-- JSTL if-else문 -->
	<c:choose>
		<c:when test="${ 10 > 5 }">
			<h2>10은 5보다 크다</h2>
		</c:when>
		<c:otherwise>
			<h2>10은 5보다 작다</h2>
		</c:otherwise>
	</c:choose>
	
	<!-- JSTL if-else if문 -->
	<c:set var="scr" value="85"></c:set>
	<c:choose>
		<c:when test="${scr >= 90 }">
			<h2>수</h2>
		</c:when>
		<c:when test="${scr >= 80 }">
			<h2>우</h2>
		</c:when>
		<c:when test="${scr >= 70 }">
			<h2>미</h2>
		</c:when>
		<c:when test="${scr >= 60 }">
			<h2>양</h2>
		</c:when>
		<c:otherwise>
			<h2>가</h2>
		</c:otherwise>
	</c:choose>
	
</body>
</html>