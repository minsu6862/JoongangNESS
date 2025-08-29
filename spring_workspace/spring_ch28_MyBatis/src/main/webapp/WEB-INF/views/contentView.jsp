<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 내용 보기</title>
</head>
<body>
	<h2>글 내용</h2>
	<hr>
	글 제목 : ${boardDto.board_title }<br><br>
	글 내용 : ${boardDto.board_content }<br><br>
	글 작성자 : ${boardDto.board_name }<br><br>
	글 등록일 : ${boardDto.board_date }
	<hr>
	<input type="button" value="글수정" onclick="javascript:window.location.href='content_modify?board_num=${boardDto.board_num}'">
	<input type="button" value="목록으로" onclick="location.href='boardlist'">
</body>
</html>