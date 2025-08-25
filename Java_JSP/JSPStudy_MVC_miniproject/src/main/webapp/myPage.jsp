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
  <main class="container">
    <section class="post-edit">
      <h2 class="board-title">마이페이지</h2>
      <form class="edit-form" action="updateMember.do" method="post">

        <!-- 아이디 (readonly) -->
        <div class="form-group">
          <label for="userId">아이디</label>
          <input class="input full" type="text" id="userId" name="memberId" value="${memberDto.memberid}" readonly>
        </div>

        <!-- 비밀번호 (입력 필요) -->
        <div class="form-group">
          <label for="userPw">비밀번호 확인</label>
          <input class="input full" type="password" id="userPw" name="memberPw" placeholder="현재 비밀번호 입력" required>
          <c:if test="${param.msg == 4}">autofocus</c:if>
        </div>

        <!-- 이름 -->
        <div class="form-group">
          <label for="userName">이름</label>
          <input class="input full" type="text" id="userName" name="memberName" value="${memberDto.membername}">
          <c:if test="${param.msg == 3}">autofocus</c:if>
        </div>

        <!-- 이메일 -->
        <div class="form-group">
          <label for="userEmail">이메일</label>
          <input class="input full" type="email" id="userEmail" name="memberEmail" value="${memberDto.memberemail}">
        </div>

        <!-- 등록일 (readonly) -->
        <div class="form-group">
          <label for="regDate">등록일</label>
          <input class="input full" type="text" id="regDate" name="memberDate" value="${memberDto.memberdate}" readonly>
        </div>

        <!-- 버튼 -->
        <div class="form-actions">
        	<c:if test="${param.msg == 1 }">
          		<p style="color:red;">회원정보 수정 성공</p>
        	</c:if>
        	<c:if test="${param.msg == 2 }">
          		<p style="color:red;">회원정보 수정 실패 - DB업데이트 오류</p>
        	</c:if>
        	<c:if test="${param.msg == 3 }">
          		<p style="color:red;">이름과 이메일은 필수 입력사항입니다.</p>
        	</c:if>
        	<c:if test="${param.msg == 4 }">
          		<p style="color:red;">비밀번호가 틀립니다. 다시 확인해주세요</p>
        	</c:if>
          <button type="submit" class="btn btn-primary">회원정보 수정</button>
          <a href="list.do" class="btn btn-outline">목록으로</a>
        </div>
      </form>
    </section>
  </main>

  <%@ include file="include/footer.jsp" %>
</body>
</html>