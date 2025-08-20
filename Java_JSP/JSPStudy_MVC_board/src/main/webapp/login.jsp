<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>로그인</title>
  <link rel="stylesheet" href="css/login.css">
</head>
<body>
  <div class="login-container">
    <h2>로그인</h2>
    <form action="loginOk.do" method="post">
      <input type="text" name="id" placeholder="아이디 (또는 이메일)">
      <input type="password" name="pw" placeholder="비밀번호">
      <div class="checkbox">
        <input type="checkbox" id="remember">
        <label for="remember">로그인 상태 유지</label>
      </div>
      <button type="submit">로그인</button>
      <div>
      	<c:if test="${param.msg == 1 }">
      		<p style="color:red;">아이디 또는 비밀번호가 잘못되었습니다.</p>
      	</c:if>
      	<c:if test="${param.msg == 2 }">
      		<p style="color:red;">글을 작성하려면 로그인을 필요합니다.</p>
      	</c:if>
      </div>
    </form>
  </div>
</body>
</html>