<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp" %>

<div class="board-container">
    <h2 class="title">게시글 작성</h2>

    <form action="${pageContext.request.contextPath}/writeOk" method="post" class="form-box">
        <label>제목</label>
        <input type="text" name="title" required>

        <label>작성자</label>
        <input type="text" name="writer" value="${sessionId }" readonly>

        <label>내용</label>
        <textarea name="content" rows="10" style="resize: vertical; padding:12px; border:1px solid #ccc; border-radius:6px; font-size:1rem; outline:none;"></textarea>

        <button type="submit" class="btn">등록하기</button>
    </form>
</div>

<%@ include file="../common/footer.jsp" %>