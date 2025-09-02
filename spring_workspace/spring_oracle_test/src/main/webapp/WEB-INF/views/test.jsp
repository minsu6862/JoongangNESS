<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}resources/css/test.css">
<title>외부파일 불러오기</title>
</head>
<body>
	<h2>이미지 불러오기</h2>
	<hr>
	<!-- <img src="resources/img/Icon.png"> -->
	<img src="${pageContext.request.contextPath}resources/img/Icon.png">
</body>
</html>