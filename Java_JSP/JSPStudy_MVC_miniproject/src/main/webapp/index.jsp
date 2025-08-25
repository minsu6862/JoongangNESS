<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>Clean Corp - 메인</title>
  <link rel="stylesheet" href="css/boardStyle.css" />
</head>
<body>
  <!-- 헤더 -->
  <%@ include file="include/header.jsp" %>

  <!-- Hero 영역 -->
  <section class="hero">
    <div class="container hero-inner">
      <h2 class="hero-title">WEL SOLUTION, 신뢰할 수 있는 파트너</h2>
      <p class="hero-desc">
        WebSolution는 IT 컨설팅과 소프트웨어 개발을 통해<br />
        고객과 함께 성장하는 기업입니다.
      </p>
      <div class="hero-actions">
        <a href="list.do" class="btn btn-primary">공지사항 보기</a>
        <a href="signUp.do" class="btn signup-bt">회원가입</a>
      </div>
    </div>
  </section>

  <!-- 특징 섹션 -->
  <section class="features container">
    <h3 class="section-title">Our Services</h3>
    <div class="features-grid">
      <div class="feature-card">
        <h4>IT 컨설팅</h4>
        <p>체계적인 분석과 전략 수립을 통한 맞춤형 IT 컨설팅</p>
      </div>
      <div class="feature-card">
        <h4>솔루션 개발</h4>
        <p>웹·모바일 맞춤형 솔루션 개발 및 운영 지원</p>
      </div>
      <div class="feature-card">
        <h4>기술 지원</h4>
        <p>안정적인 시스템 운영과 보안을 위한 전문 지원</p>
      </div>
    </div>
  </section>

  <!-- 최근 글 -->
  <section class="latest-posts container">
    <h3 class="section-title">Notice & News</h3>
    <ul class="post-list">
      <li><a href="#">[공지] 추석 연휴 고객센터 운영 안내</a></li>
      <li><a href="#">신규 프로젝트 론칭 소식</a></li>
      <li><a href="#">Clean Corp 채용 공고</a></li>
    </ul>
    <div class="more"><a href="index.html" class="btn btn-outline">전체 보기</a></div>
  </section>

  <!-- 푸터 -->
  <%@ include file="include/footer.jsp" %>
</body>
</html>