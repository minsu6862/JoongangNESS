<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>Clean Board - 메인</title>
  <link rel="stylesheet" href="css/boardStyle.css" />
</head>
<body>
  <!-- 헤더 -->
  <%@ include file="include/header.jsp" %>

  <!-- Hero 영역 -->
  <section class="hero">
    <div class="container hero-inner">
      <h2 class="hero-title">깔끔하고 심플한 게시판</h2>
      <p class="hero-desc">
        자유롭게 글을 남기고 소통할 수 있는 공간입니다.<br />
        최신 글을 확인하거나, 직접 게시글을 작성해보세요.
      </p>
      <div class="hero-actions">
        <a href="list.do" class="btn btn-primary">게시판 바로가기</a>
        <a href="#" class="btn btn-outline">소개 보기</a>
      </div>
    </div>
  </section>

  <!-- 특징 섹션 -->
  <section class="features container">
    <h3 class="section-title">주요 기능</h3>
    <div class="features-grid">
      <div class="feature-card">
        <h4>깔끔한 UI</h4>
        <p>화이트·블랙·그레이 톤의 심플한 디자인</p>
      </div>
      <div class="feature-card">
        <h4>모바일 최적화</h4>
        <p>어디서든 편리하게 게시판 이용 가능</p>
      </div>
      <div class="feature-card">
        <h4>검색 & 정렬</h4>
        <p>최신순, 조회순, 추천순 정렬 및 검색 지원</p>
      </div>
    </div>
  </section>

  <!-- 최근 글 -->
  <section class="latest-posts container">
    <h3 class="section-title">최근 게시글</h3>
    <ul class="post-list">
      <li><a href="#">서버 점검 안내 (8/21)</a></li>
      <li><a href="#">프로젝트 협업 인원 모집합니다</a></li>
      <li><a href="#">다크 모드 피드백 남겨주세요</a></li>
    </ul>
    <div class="more"><a href="index.html" class="btn btn-outline">전체 보기</a></div>
  </section>

  <!-- 푸터 -->
  <%@ include file="include/footer.jsp" %>
</body>
</html>