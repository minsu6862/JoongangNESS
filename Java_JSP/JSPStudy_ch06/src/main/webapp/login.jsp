<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<form action="loginOk.jsp">
		아이디 : <input type="text" name="loginId"><br><br>
		비밀번호 : <input type="text" name="loginPw"><br><br>
		<input type="submit" value="로그인">
	</form>
	<hr>
	<a href="loginUser.jsp">로그인 유저 페이지로 이동</a>
</body>
</html>