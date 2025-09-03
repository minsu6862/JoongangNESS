<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp" %>

<h2 class="title">로그인</h2>
<form action="${pageContext.request.contextPath}/loginOk" method="post" class="form-box">
    <label>아이디</label>
    <input type="text" name="memberid" required>
    <label>비밀번호</label>
    <input type="password" name="memberpw" required>
    <c:choose>
		<c:when test="${not empty msg}">
			<h3 style="color:red;">${msg }</h3>
		</c:when>
		<c:otherwise>
			<br>
		</c:otherwise>
	</c:choose>
    <button type="submit" class="btn">로그인</button>
</form>

<%@ include file="../common/footer.jsp" %>