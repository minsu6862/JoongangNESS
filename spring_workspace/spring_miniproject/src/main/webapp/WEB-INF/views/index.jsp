<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="common/header.jsp" %>

<section class="main-hero" 
         style="background-image:url('${pageContext.request.contextPath}/resources/img/main-bg.jpg');">
    <div class="overlay">
        <h2>만화책방에 오신 것을 환영합니다 📚</h2>
        <div class="hero-buttons">
            <a href="${pageContext.request.contextPath}/list" class="btn large">게시판 가기</a>
            <c:choose>
                <c:when test="${not empty sessionId}">
                	<a href="${pageContext.request.contextPath}/reserveForm" class="btn large">예약하기</a>
                </c:when>
                <c:otherwise>
                	<a href="${pageContext.request.contextPath}/login" class="btn large">로그인하기</a>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</section>

<%@ include file="common/footer.jsp" %>