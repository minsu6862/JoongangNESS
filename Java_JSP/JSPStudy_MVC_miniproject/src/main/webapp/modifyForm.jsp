<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>게시글 수정 - Clean Board</title>
  <link rel="stylesheet" href="css/boardStyle.css" />
</head>
<body>
  <!-- 헤더 -->
  <%@ include file="include/header.jsp" %>

  <!-- 본문 -->
  <main class="container">
    <section class="post-edit">
      <h2 class="section-title">게시글 수정</h2>
      
      <form class="edit-form" action="modifyOk.do" method="post">
      	<input type="hidden" name="bnum" value="${bDto.bnum}" />
        <div class="form-group">
          <label for="title">제목</label>
          <input id="title" name="title" type="text" class="input full" value="${bDto.btitle}" required/>
        </div>
        <div class="form-group">
          <label for="content">내용</label>
          <textarea id="content" name="content" class="input textarea full" required>${bDto.bcontent}</textarea>
        </div>
        <div class="form-actions">
          <a href="content.do?bnum=${bDto.bnum}" class="btn btn-outline">취소</a>
          <button type="submit" class="btn btn-primary">수정 완료</button>
        </div>
      </form>
    </section>
  </main>

  <!-- 푸터 -->
  <%@ include file="include/footer.jsp" %>
</body>
</html>