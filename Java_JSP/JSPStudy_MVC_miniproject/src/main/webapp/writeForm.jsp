<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>글쓰기 - Clean Board</title>
  <link rel="stylesheet" href="css/boardStyle.css" />
</head>
<body>
  <!-- 헤더 -->
  <%@ include file="include/header.jsp" %>

  <!-- 본문 -->
  <main class="container">
    <section class="post-write">
      <h2 class="section-title">새 글 작성</h2>
      <form class="write-form" action="writeOk.do" method="post">
      	<div class="form-group">
          <label for="author">작성자</label>
          <input id="author" name="author" type="text" class="input full" value="${sessionScope.sessionId }" readonly />
        </div>
        <div class="form-group">
          <label for="title">제목</label>
          <input id="title" name="title" type="text" class="input full" placeholder="제목을 입력하세요" />
        </div>
        <div class="form-group">
          <label for="content">내용</label>
          <textarea id="content" name="content" class="input textarea full" placeholder="내용을 입력하세요"></textarea>
        </div>
        <div class="form-group">
          <label for="category">분류</label>
          <select id="category" class="input full">
            <option>자유</option>
            <option>공지</option>
            <option>이벤트</option>
          </select>
        </div>
        <div class="form-actions">
          <a href="list.do" class="btn btn-outline">취소</a>
          <button type="submit" class="btn btn-primary">등록</button>
        </div>
      </form>
    </section>
  </main>

  <!-- 푸터 -->
  <%@ include file="include/footer.jsp" %>
</body>
</html>