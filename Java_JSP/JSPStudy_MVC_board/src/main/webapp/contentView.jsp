<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>게시글 상세 - Clean Board</title>
  <link rel="stylesheet" href="css/boardStyle.css" />
</head>
<body>
  <!-- 헤더 -->
  <header class="site-header">
    <div class="container header-inner">
      <h1 class="logo">Clean Board</h1>
      <nav class="actions">
        <a class="btn btn-outline" href="#">로그인</a>
        <a class="btn" href="#">회원가입</a>
      </nav>
    </div>
  </header>

  <!-- 본문 -->
  <main class="container">
    <article class="post-view">
      <header class="post-header">
        <h2 class="post-title">${bDto.btitle}</h2>
        <div class="post-meta">
          <span class="writer">${bDto.memberid}</span>
          <span class="date">${bDto.bdate}</span>
          <span class="views">조회 ${bDto.bhit}</span>
        </div>
      </header>
      <div class="post-body">
        ${bDto.bcontent}
      </div>
      <footer class="post-footer">
        <div class="post-actions">
          <a href="list.do" class="btn btn-outline">목록</a>
          <a href="modify.do" class="btn">수정</a>
          <a href="delete.do?bnum=${bDto.bnum}" class="btn" onclick="return confirm('정말로 이 게시글을 삭제하시겠습니까?')">삭제</a>
        </div>
      </footer>
    </article>

    <!-- 댓글 -->
    <section class="comments-wrap">
      <h3 class="comments-title">댓글 3</h3>
      <ul class="comments-list">
        <li class="comment">
          <div class="comment-meta"><strong>mango</strong> · 2025-08-18</div>
          <div class="comment-body">공지 확인했습니다. 수고 많으십니다!</div>
        </li>
        <li class="comment">
          <div class="comment-meta"><strong>uiux</strong> · 2025-08-18</div>
          <div class="comment-body">점검 시간 공지 감사합니다 🙏</div>
        </li>
        <li class="comment">
          <div class="comment-meta"><strong>choi</strong> · 2025-08-19</div>
          <div class="comment-body">알려주셔서 감사합니다!</div>
        </li>
      </ul>

      <form class="comment-form">
        <textarea class="input textarea" placeholder="댓글을 입력하세요"></textarea>
        <button type="submit" class="btn btn-primary">댓글 작성</button>
      </form>
    </section>
  </main>

  <!-- 푸터 -->
  <footer class="site-footer">
    <div class="container">
      <p>© 2025 Clean Board. All rights reserved.</p>
    </div>
  </footer>
</body>
</html>