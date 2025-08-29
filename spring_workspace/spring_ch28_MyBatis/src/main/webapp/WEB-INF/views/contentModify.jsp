<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 내용 보기</title>
</head>
<body>
	<h2>글 수정</h2>
	<hr>
	<form action="modifyOk" method="post">
		<input type="hidden" name="board_num" value="${boardDto.board_num}">
		
		글 제목 : <input type="text" name="board_title" value="${boardDto.board_title}"><br><br>
		글 내용 : <textarea name="board_content" rows="10" cols="50">${boardDto.board_content}</textarea><br><br>
		글 작성자 : <input type="text" name="board_name" value="${boardDto.board_name}"><br><br>
		글 등록일 : ${boardDto.board_date}
		
		<hr>
		<input type="submit" value="수정완료">
		<input type="button" value="취소" onclick="history.go(-1)">
	</form>
</body>
</html>