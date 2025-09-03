<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>만화책방</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<header>
    <div class="navbar">
        <h1 class="logo">
			<a href="${pageContext.request.contextPath}/index">만화책방</a>
		</h1>
        <nav>
            <ul>
                <li><a href="${pageContext.request.contextPath}/list">게시판</a></li>
                <li><a href="${pageContext.request.contextPath}/reserveForm">예약접수</a></li>
                <li><a href="${pageContext.request.contextPath}/infomap">오시는길</a></li>
            </ul>
        </nav>
        <div class="user-menu">
            <c:choose>
                <c:when test="${not empty sessionId}">
                	<span>${sessionName}님</span> |
                    <a href="${pageContext.request.contextPath}/logout">로그아웃</a>
                </c:when>
                <c:otherwise>
                	<a href="${pageContext.request.contextPath}/login">로그인</a> | 
                    <a href="${pageContext.request.contextPath}/join">회원가입</a>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</header>
<main>