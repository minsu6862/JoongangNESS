<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>마이페이지</title>
  <link rel="stylesheet" href="css/boardStyle.css" />
</head>
<body>
  <%@ include file="include/header.jsp" %>
<!-- 이거 만들어야한다 만들다 말았다 -->
  <main class="container">
    <section class="post-edit">
      <h2 class="board-title">마이페이지</h2>
      <form class="edit-form" action="updateUser.do" method="post">

        <!-- 아이디 (readonly) -->
        <div class="form-group">
          <label for="userId">아이디</label>
          <input class="input full" type="text" id="userId" name="userId" value="${user.id}" readonly>
        </div>

        <!-- 비밀번호 (입력 필요) -->
        <div class="form-group">
          <label for="userPw">비밀번호 확인</label>
          <input class="input full" type="password" id="userPw" name="userPw" placeholder="현재 비밀번호 입력" required>
        </div>

        <!-- 이름 -->
        <div class="form-group">
          <label for="userName">이름</label>
          <input class="input full" type="text" id="userName" name="userName" value="${user.name}">
        </div>

        <!-- 이메일 -->
        <div class="form-group">
          <label for="userEmail">이메일</label>
          <input class="input full" type="email" id="userEmail" name="userEmail" value="${user.email}">
        </div>

        <!-- 등록일 (readonly) -->
        <div class="form-group">
          <label for="regDate">등록일</label>
          <input class="input full" type="text" id="regDate" name="regDate" value="${user.regDate}" readonly>
        </div>

        <!-- 버튼 -->
        <div class="form-actions">
          <button type="submit" class="btn btn-primary">회원정보 수정</button>
        </div>
      </form>
    </section>
  </main>

  <%@ include file="include/footer.jsp" %>
</body>
</html>