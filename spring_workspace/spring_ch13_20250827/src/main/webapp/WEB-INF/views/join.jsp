<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<h2>회원가입</h2>
	<hr>
	<h3>get방식 전달</h3>
	<form action="joinOk" method="get">
		아이디 : <input type="text" name="memberId"><br><br>
		비밀번호 : <input type="text" name="memberPw"><br><br>
		이름 : <input type="text" name="memberName"><br><br>
		나이 : <input type="text" name="memberAge"><br><br>
		<input type="submit" value="회원가입">
	</form>
	
	<hr>
	<h3>post방식 전달</h3>
	<form action="joinOk" method="post">
		아이디 : <input type="text" name="memberId"><br><br>
		비밀번호 : <input type="text" name="memberPw"><br><br>
		이름 : <input type="text" name="memberName"><br><br>
		나이 : <input type="text" name="memberAge"><br><br>
		<input type="submit" value="회원가입">
	</form>
</body>
</html>