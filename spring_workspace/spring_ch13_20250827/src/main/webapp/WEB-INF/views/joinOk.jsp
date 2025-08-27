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
	아이디 : ${memberDto.memberId }<br>
	비밀번호 : ${memberDto.memberPw }<br>
	이름 : ${memberDto.memberName }<br>
	나이 : ${memberDto.memberAge }<br>
</body>
</html>