<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="js/join.js"></script>
<title>회원 가입</title>
</head>
<body>
	<h2>회원 가입</h2>
	<hr>
	<form action="memberJoinOk.jsp" name="joinForm" method="post">
		아이디 : <input type="text" name="mid"><br><br>
		비밀번호 : <input type="password" name="mpw"><br><br>
		비밀번호 확인 : <input type="password" name="mpwCheck"><br><br>
		이름 : <input type="text" name="mname"><br><br>
		이메일 : <input type="text" name="memail"><br><br>
		주소 : <input type="text" name="maddr"><br><br>
		<input type="button" value="회원가입" onclick="joinCheck()">
	</form>
</body>
</html>