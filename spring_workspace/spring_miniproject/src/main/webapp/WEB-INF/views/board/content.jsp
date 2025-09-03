<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="../common/header.jsp" %>

<div class="board-container">
    <h2 class="title">게시글 상세보기</h2>

    <!-- 제목 -->
    <div>
        <span class="label">제목</span>
        <div class="post-title" name="btitle">${boardDto.btitle}</div>
    </div>

    <!-- 메타(작성자 · 조회수 · 작성일) -->
    <div class="post-meta">
        <span name="membername">작성자 ${boardDto.bwriter}</span>
        <span class="dot"></span>
        <span>조회수 ${boardDto.bhit}</span> <%-- 필드명이 views/viewCnt라면 맞게 바꿔주세요 --%>
        <span class="dot"></span>
        <span><fmt:formatDate value="${boardDto.bdate}" pattern="yyyy-MM-dd HH:mm" /></span>
    </div>

    <!-- 본문 -->
    <div class="post-content" name="bcontent">
        <c:out value="${boardDto.bcontent}" />
    </div>

    <!-- 버튼 -->
    <div class="btn-group">
        <a href="${pageContext.request.contextPath}/modify?bnum=${boardDto.bnum}" class="btn">수정</a>

        <!-- 삭제: POST 사용 권장 -->
        <form action="${pageContext.request.contextPath}/delete" method="post" style="display:inline;">
            <input type="hidden" name="bnum" value="${boardDto.bnum}">
            <input type="hidden" name="bwriter" value="${boardDto.bwriter}">
            <button type="submit" class="btn" onclick="return confirm('정말 삭제하시겠습니까?');">삭제</button>
        </form>

        <a href="${pageContext.request.contextPath}/list" class="btn">목록</a>
    </div>
</div>

<%@ include file="../common/footer.jsp" %>