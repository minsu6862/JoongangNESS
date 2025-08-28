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
	<table border="1" cellspacing="0" cellpadding="0">
		<form action="write" method="post">
			<tr>
				<th>이름</th>
				<td><input type="text" name="board_name" size="60"></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="board_title" size="60"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="10" cols="50" name="board_content"></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="글작성">
					<input type="button" value="글목록" onclick="">
				</td>
			</tr>
		</form>
	</table>
</body>
</html>