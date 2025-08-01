<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 양식</title>
</head>
<body>
	<h2>회원 가입 양식</h2>
	<hr>
	<form action="joinOk2.jsp">
		아이디 : <input type="text" name="memberId"><br><br>
		비밀번호 : <input type="password" name="memberPw"><br><br>
		이름 : <input type="text" name="memberName"><br><br>
		나이 : <input type="text" name="memberAge"><br><br>
		성별 : <input type="radio" name="gender" value="male">남자 
		<input type="radio" name="gender" value="female">여자<br><br>
		이메일 : <input type="text" name="memberEmail1"> @
		<select name="memberEmail2">
			<option>gmail.com</option>
			<option>naver.com</option>
			<option>daum.com</option>
		</select>
		<br><br>
		취미 : <!-- 여러개 체크할 경우 자료타입이 배열로 날아감 -->
		<input type="checkbox" name="hobby" value="game">게임
		<input type="checkbox" name="hobby" value="sport">운동
		<input type="checkbox" name="hobby" value="book">독서
		<input type="checkbox" name="hobby" value="movie">영화
		<input type="checkbox" name="hobby" value="walking">산책
		<input type="checkbox" name="hobby" value="music">음악
		<input type="checkbox" name="hobby" value="swim">수영
		<input type="checkbox" name="hobby" value="collect">수집
		<br><br>
		자기소개 : <br>
		<textarea row="5" cols="50" name="intro">
		</textarea>
		<br><br>
		<input type="submit" value="회원가입">
		<input type="reset" value="재작성">
	</form>
</body>
</html>