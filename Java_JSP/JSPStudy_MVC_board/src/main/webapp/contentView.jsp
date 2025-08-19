<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        <h2 class="post-title">서버 점검 안내 (8/21 02:00–04:00)</h2>
        <div class="post-meta">
          <span class="writer">관리자</span>
          <span class="date">2025-08-18</span>
          <span class="views">조회 1,024</span>
        </div>
      </header>
      <div class="post-body">
        <p>
          안녕하세요, Clean Board 운영팀입니다.<br />
          안정적인 서비스 제공을 위해 아래와 같이 서버 점검을 진행합니다.
        </p>
        <ul>
          <li>점검 일시: 2025년 8월 21일 02:00 ~ 04:00</li>
          <li>점검 내용: 서버 보안 패치 및 성능 최적화</li>
          <li>영향: 점검 시간 동안 게시판 접속 불가</li>
        </ul>
        <p>이용에 불편을 드려 죄송하며, 더 나은 서비스를 위해 최선을 다하겠습니다.</p>
      </div>
      <footer class="post-footer">
        <div class="post-actions">
          <a href="index.html" class="btn btn-outline">목록</a>
          <a href="#" class="btn">수정</a>
          <a href="#" class="btn">삭제</a>
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