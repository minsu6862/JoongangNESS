<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>회원가입</title>
  <link rel="stylesheet" href="css/login.css">
</head>
<body>
  <div class="login-container">
    <h2>회원가입</h2>
    <form action="signUpOk.do" method="post">
  		<input type="text" name="id" placeholder="아이디" class="input-field" required>
  		<input type="password" name="pw" placeholder="비밀번호" class="input-field" required>
  		<input type="password" name="pwCheck" placeholder="비밀번호 확인" class="input-field" required>
  		<input type="text" name="name" placeholder="이름" class="input-field" required>
  		<input type="email" name="email" placeholder="이메일" class="input-field" required>
  		<div>
        <c:if test="${param.msg == 1 }">
          <p style="color:red;">비밀번호를 다시한번 확인해 주십시오</p>
        </c:if>
        <c:if test="${param.msg == 2 }">
          <p style="color:red;">이미 사용중인 아이디입니다. 다른 아이디를 입력해주세요</p>
        </c:if>
        <c:if test="${param.msg == 3 }">
          <p style="color:red;">시스템 오류가 발생했습니다. 다시 회원가입을 시도해 주세요</p>
        </c:if>
      </div>
  		<button type="submit">회원가입</button>
  		<button type="button" onclick="location.href='login.do'">로그인으로</button>
	</form>
  </div>
</body>
</html>