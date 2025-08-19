<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
  <header class="site-header">
    <div class="container header-inner">
      <h1 class="logo">Clean Board</h1>
      <nav class="actions">
        <a class="btn btn-outline" href="#">로그아웃</a>
      </nav>
    </div>
  </header>

  <!-- 본문 -->
  <main class="container">
    <section class="post-edit">
      <h2 class="section-title">게시글 수정</h2>
      <form class="edit-form">
        <div class="form-group">
          <label for="title">제목</label>
          <input id="title" type="text" class="input full" value="서버 점검 안내 (8/21 02:00–04:00)" />
        </div>
        <div class="form-group">
          <label for="content">내용</label>
          <textarea id="content" class="input textarea full">안녕하세요, Clean Board 운영팀입니다.
안정적인 서비스 제공을 위해 아래와 같이 서버 점검을 진행합니다.

- 점검 일시: 2025년 8월 21일 02:00 ~ 04:00
- 점검 내용: 서버 보안 패치 및 성능 최적화
- 영향: 점검 시간 동안 게시판 접속 불가

이용에 불편을 드려 죄송하며, 더 나은 서비스를 위해 최선을 다하겠습니다.
          </textarea>
        </div>
        <div class="form-actions">
          <a href="post.html" class="btn btn-outline">취소</a>
          <button type="submit" class="btn btn-primary">수정 완료</button>
        </div>
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