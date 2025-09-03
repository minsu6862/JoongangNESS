<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../common/header.jsp" %>

<div class="form-container">
    <h2 class="title">게시글 수정</h2>

    <form action="${pageContext.request.contextPath}/modifyOk" method="post" class="form-box">
        <!-- 게시글 번호 hidden -->
        <input type="hidden" name="bnum" value="${boardDto.bnum}">

        <!-- 제목 -->
        <label for="btitle">제목</label>
        <input type="text" id="btitle" name="btitle" value="${boardDto.btitle}" required>

        <!-- 작성자 (수정 불가) -->
        <label for="bwriter">작성자</label>
        <input type="text" id="bwriter" name="bwriter" value="${boardDto.bwriter}" readonly>

        <!-- 내용 -->
        <label for="bcontent">내용</label>
        <textarea id="bcontent" name="bcontent" rows="10" required>${boardDto.bcontent}</textarea>

        <!-- 버튼 -->
        <div class="edit-btn-group">
    		<button type="submit" class="btn btn-primary" onclick="return confirm('해당 내용으로 수정하시겠습니까?')">수정</button>
    		<a href="${pageContext.request.contextPath}/list" class="btn btn-secondary">취소</a>
		</div>
    </form>
</div>

<%@ include file="../common/footer.jsp" %>