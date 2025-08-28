<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원가입</h2>
	<hr>
	<form action="joinOk" method="post">
		아이디 : <input type="text" name="member_id"><br><br>
		비밀번호 : <input type="password" name="member_pw"><br><br>
		이름 : <input type="text" name="member_name"><br><br>
		나이 : <input type="text" name="member_age"><br><br>
		<input type="submit" value="가입신청">
	</form>
</body>
</html>