<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>모든 회원 리스트</title>
</head>
<body>
	<h2>모든 회원 리스트</h2>
	<hr>
	<c:forEach items="${memberDtos }" var="memberDto">
		<h3>
			${memberDto.member_id } / ${memberDto.member_name } / ${memberDto.member_age }
		</h3>
	</c:forEach>
</body>
</html>