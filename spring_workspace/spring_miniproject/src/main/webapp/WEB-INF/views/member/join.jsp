<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ include file="../common/header.jsp" %>

<h2 class="title">회원가입</h2>
<form action="${pageContext.request.contextPath}/joinOk" method="post" class="form-box">
    <label>아이디</label>
    <input type="text" name="memberid" required>
    <label>비밀번호</label>
    <input type="password" name="memberpw" required>
    <label>이름</label>
    <input type="text" name="membername" required>
    <!-- <label>이메일</label>
    <input type="email" name="email" required> -->
	<c:choose>
		<c:when test="${not empty msg}">
			<h3 style="color:red;">${msg }</h3>
		</c:when>
		<c:otherwise>
			<br>
		</c:otherwise>
	</c:choose>
    <button type="submit" class="btn">가입하기</button>
</form>

<%@ include file="../common/footer.jsp" %>