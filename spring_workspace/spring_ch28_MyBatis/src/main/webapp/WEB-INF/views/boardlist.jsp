<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글목록</title>
</head>
<body>
	<h2>게시판 글목록</h2>
	<hr>
	글번호 / 글제목 / 글쓴이 / 조회수 / 등록일 <br><br>
	<c:forEach items="${boardDtos }" var="boardDto">
		${boardDto.board_num } / <a href="content_view?board_num=${boardDto.board_num }">${boardDto.board_title }</a> / ${boardDto.board_name } / ${boardDto.board_hit } / ${boardDto.board_date }<br>
	</c:forEach>
</body>
</html>