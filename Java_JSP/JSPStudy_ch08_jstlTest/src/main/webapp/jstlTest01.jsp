<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 연습1</title>
</head>
<body>
	<%
	String str = "Korea";
	request.setAttribute("kor", str);
	
	//int scroe = 100;
	%>
	<h1>내가 태어난 국가는 <%= str %>입니다.</h1><br>
	<h1>내가 태어난 국가는 ${ kor }입니다.</h1>
	
	<!-- 자바 문법 안에 int score = 100을 입력한것과 같음 -->
	<c:set var="score" value="100"></c:set>
	나의 실수 : ${score };
</body>
</html>