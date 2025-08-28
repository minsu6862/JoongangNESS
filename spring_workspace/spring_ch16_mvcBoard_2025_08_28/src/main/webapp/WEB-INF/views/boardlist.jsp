<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
</head>
<body>
	<h2>게시판 글 목록</h2>
	<hr>
	<table border="1" cellspacing="0" cellpadding="0">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>등록일</th>
		</tr>
		
		<c:forEach items="${boardDtos }" var="boardDto">
			<tr>
				<th>${boardDto.board_num }</th>
				<th><a href="content_view?board_num=${boardDto.board_num }">${boardDto.board_title }</a></th>
				<th>${boardDto.board_name }</th>
				<th>${boardDto.board_hit }</th>
				<th>${boardDto.board_date }</th>
			</tr>
		</c:forEach>
	</table>
	<hr>
	<form action="write_form">
			<input type="submit" value="글쓰기">
	</form>
</body>
</html>