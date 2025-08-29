<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글쓰기</title>
</head>
<body>
	<h2>게시판 글쓰기</h2>
	<hr>
	<form action="boardwrite" method="post">
		<table border="1">
			<tr>
				<td>제목</td>
				<td><input type="text" name="board_title" required style="width: 300px;"></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="board_name" required style="width: 200px;"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="board_content" required rows="10" cols="50"></textarea></td>
			</tr>
		</table>
		<br>
		<input type="submit" value="글쓰기">
		<input type="button" value="목록보기" onclick="location.href='boardlist'">
	</form>
</body>
</html>