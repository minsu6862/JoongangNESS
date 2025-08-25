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
  	<%@ include file="include/header.jsp" %>

  	<main class="container">
    	<section class="board-head">
      	<h2 class="board-title">공지사항</h2>
      	<div class="board-tools">
      		<!-- 검색 폼의 선택값 유지를 위한 수정 -->
			<form class="search" action="list.do" method="get">
    			<label class="sr-only" for="searchType">검색구분</label>
    			<select id="searchType" name="searchType" class="select">
        			<option value="title" <c:if test="${searchType == 'title'}">selected</c:if>>제목</option>
        			<option value="content" <c:if test="${searchType == 'content'}">selected</c:if>>내용</option>
        			<option value="writer" <c:if test="${searchType == 'writer'}">selected</c:if>>작성자</option>
    			</select>

    			<label class="sr-only" for="q">검색어</label>
    			<input id="q" class="input" type="text" name="searchKeyword" placeholder="검색어 입력" value="${searchKeyword}" />

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

      <!-- 검색 결과 없음 메시지 -->
      <c:if test="${noSearchResult}">
        <div class="no-result" style="text-align: center; padding: 50px 0;">
          <p style="font-size: 18px; color: #666; margin-bottom: 20px;">${searchMessage}</p>
          <a href="list.do" class="btn">전체 목록 보기</a>
        </div>
      </c:if>

      <!-- 기존 테이블은 검색 결과가 있을 때만 표시 -->
      <c:if test="${not noSearchResult}">
        <div class="table-wrap">
          <table class="table">
            <thead>
              <tr>
                <th scope="col" class="col-no">번호</th>
                <th scope="col" class="col-title">제목</th>
                <th scope="col" class="col-writer">작성자</th>
                <th scope="col" class="col-writer">이메일</th>
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
                <td class="col-writer">${bDto.memberDto.memberemail}</td>
                <td class="col-date">${fn:substring(bDto.bdate, 0, 10)}</td>
                <td class="col-views">${bDto.bhit}</td>
              </tr>
              </c:forEach>
            </tbody>
          </table>
        </div>
        
        <!-- 페이징도 결과가 있을 때만 표시 -->
        <nav class="pagination" aria-label="페이지네이션">
          <c:if test="${currentPage > 1}">
            <a href="list.do?page=1<c:if test='${not empty searchType and not empty searchKeyword}'>&searchType=${searchType}&searchKeyword=${searchKeyword}</c:if>" class="page prev" aria-label="이전 페이지">‹‹</a>
          </c:if>
          <!-- 첫번째 페이지로 이동 화살표 -->
          <c:if test="${startPage > 1}">
            <a href="list.do?page=${startPage - 1}<c:if test='${not empty searchType and not empty searchKeyword}'>&searchType=${searchType}&searchKeyword=${searchKeyword}</c:if>" class="page prev" aria-label="이전 페이지">‹</a>
          </c:if>

          <c:forEach begin="${startPage}" end="${endPage}" var="i">
            <c:choose>
              <c:when test="${i == currentPage}">
                <a href="list.do?page=${i}<c:if test='${not empty searchType and not empty searchKeyword}'>&searchType=${searchType}&searchKeyword=${searchKeyword}</c:if>" class="page is-active">${i}</a> | 
              </c:when>
              <c:otherwise>
                <a href="list.do?page=${i}<c:if test='${not empty searchType and not empty searchKeyword}'>&searchType=${searchType}&searchKeyword=${searchKeyword}</c:if>" class="page">${i}</a> | 
              </c:otherwise>
            </c:choose>
          </c:forEach>
          <!-- 그룹 이동 화살표 -->
          <c:if test="${endPage < totalPage}">
            <a href="list.do?page=${endPage + 1}<c:if test='${not empty searchType and not empty searchKeyword}'>&searchType=${searchType}&searchKeyword=${searchKeyword}</c:if>" class="page next" aria-label="다음 페이지">›</a>
          </c:if>

          <!-- 마지막 페이지로 이동 화살표 -->
          <c:if test="${currentPage < totalPage}">
            <a href="list.do?page=${totalPage}<c:if test='${not empty searchType and not empty searchKeyword}'>&searchType=${searchType}&searchKeyword=${searchKeyword}</c:if>" class="page next" aria-label="다음 페이지">››</a>
          </c:if>
        </nav>
      </c:if>
    </section>
  </main>

	<%@ include file="include/footer.jsp" %>

  <!-- 모바일에서 표를 카드로 전환하는 접근성용 템플릿 -->
  <template id="row-labels">
    <span data-label="작성자"></span>
    <span data-label="작성일"></span>
    <span data-label="조회"></span>
  </template>
</body>
</html>