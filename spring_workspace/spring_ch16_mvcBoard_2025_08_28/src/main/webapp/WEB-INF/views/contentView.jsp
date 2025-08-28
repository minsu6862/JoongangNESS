<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글</title>
</head>
<body>
	<h2>게시판 글 상세보기</h2>
	<hr>
	<table border="1" cellspacing="0" cellpadding="0" width="600">
        <tr>
            <th width="100">제목</th>
            <td>${boardDto.board_title}</td>
        </tr>
        <tr>
            <th>작성자</th>
            <td>${boardDto.board_name}</td>
        </tr>
        <tr>
            <th>조회수</th>
            <td>${boardDto.board_hit}</td>
        </tr>
        <tr>
            <th>등록일</th>
            <td>${boardDto.board_date}</td>
        </tr>
        <tr>
            <th>내용</th>
            <td height="200" style="vertical-align: top; padding: 10px;">
                ${boardDto.board_content}
            </td>
        </tr>
    </table>
	<hr>
	<form action="boardlist">
			<input type="submit" value="글쓰기">
	</form>
</body>
</html>