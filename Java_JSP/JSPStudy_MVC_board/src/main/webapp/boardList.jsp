<%@page import="java.util.List"%>
<%@page import="dao.BoardDao"%>
<%@page import="dto.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>자유 게시판</title>
  <link rel="stylesheet" href="css/boardStyle.css" />
</head>
<body>
  	<header class="site-header">
    	<div class="container header-inner">
      	<h1 class="logo">Board</h1>
      	<nav class="actions">
        	<a class="btn btn-outline" href="#">로그인</a>
        	<a class="btn" href="#">회원가입</a>
      	</nav>
    	</div>
  	</header>

  	<main class="container">
    	<section class="board-head">
      	<h2 class="board-title">자유 게시판</h2>
      	<div class="board-tools">
        	<form class="search" onsubmit="return false;">
          	<label class="sr-only" for="q">검색</label>
          	<input id="q" class="input" type="search" placeholder="제목, 내용, 작성자 검색" />
          	<button class="btn" type="submit">검색</button>
        	</form>
        	<a class="btn btn-primary" href="write.do">글쓰기</a>
      	</div>
    	</section>

    <section class="board-list">
      <div class="list-meta">
        <div class="count">전체 <strong>128</strong>건</div>
        <div class="sort">
          <button class="chip chip-active" type="button">최신순</button>
          <button class="chip" type="button">조회순</button>
          <button class="chip" type="button">추천순</button>
        </div>
      </div>

	<div class="table-wrap">
    	<table class="table">
    		<thead>
            	<tr>
              	<th scope="col" class="col-no">번호</th>
              	<th scope="col" class="col-title">제목</th>
              	<th scope="col" class="col-writer">작성자</th>
              	<th scope="col" class="col-date">작성일</th>
              	<th scope="col" class="col-views">조회</th>
            	</tr>
          	</thead>
          	<tbody>
            	<c:forEach items="${bDtos}" var="bDto">
            	<tr>
              	<td class="col-no">${bDto.bnum}</td>
              	<td class="col-title">
              		<c:choose>
              			<c:when test="${fn:length(bDto.btitle) > 25}">
              				<a href="content.do?bnum=${bDto.bnum}" class="link">${fn:substring(bDto.btitle, 0, 25)}...</a>
              			</c:when>
              			<c:otherwise>
              				<a href="content.do?bnum=${bDto.bnum}" class="link">${bDto.btitle}</a>
              			</c:otherwise>
              		</c:choose>
              	</td>
              	<td class="col-writer">${bDto.memberid}</td>
              	<td class="col-date">${fn:substring(bDto.bdate, 0, 10)}</td>
              	<td class="col-views">${bDto.bhit}</td>
            	</tr>
            	</c:forEach>
          	</tbody>
        </table>
	</div>

      <nav class="pagination" aria-label="페이지네이션">
        <a href="#" class="page prev" aria-label="이전 페이지">‹</a>
        <a href="#" class="page is-active">1</a>
        <a href="#" class="page">2</a>
        <a href="#" class="page">3</a>
        <span class="page ellipsis">…</span>
        <a href="#" class="page">9</a>
        <a href="#" class="page">10</a>
        <a href="#" class="page next" aria-label="다음 페이지">›</a>
      </nav>
    </section>
  </main>

  <footer class="site-footer">
    <div class="container">
      <p>© 2025 Clean Board. All rights reserved.</p>
    </div>
  </footer>

  <!-- 모바일에서 표를 카드로 전환하는 접근성용 템플릿 -->
  <template id="row-labels">
    <span data-label="작성자"></span>
    <span data-label="작성일"></span>
    <span data-label="조회"></span>
  </template>
</body>
</html>