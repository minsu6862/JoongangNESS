<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Function 라이브러리 연습</title>
</head>
<body>
	<%
	String str = "Korea";
	
	out.println("문자열 str의 길이 : " + str.length());
	%>
	
	<c:set var="str1" value="Korea"></c:set>
	<h2>문자열의 길이 : ${ fn:length(str1) }</h2>
	<c:set var="strArr" value="${['kor', 'jpn', 'chn']}"></c:set>
	<h2>문자열의 길이 : ${fn:length(strArr) }</h2>
	<hr>
	<h2>대문자로 변환 : ${fn:toUpperCase(srt1) }</h2>
	<h2>대문자로 변환 : ${fn:toLowerCase(srt1) }</h2>
	<hr>
	<c:set var="str2" value="I love you"></c:set>
	<h2>앞 4글자 추출 : ${fn:substring(str2, 0, 4) }</h2>
</body>
</html>