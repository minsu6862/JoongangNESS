<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>header</title>
</head>
<body>
	<header class="site-header">
    	<div class="container header-inner">
      	<h1 class="logo">Board</h1>
      	<nav class="actions">
        	<c:if test="${not empty sessionScope.sessionId }">
        		<a class="btn btn-outline" href="#">${sessionScope.sessionId }님</a>
        		<a class="btn btn-outline" href="logout.do">로그아웃</a>
        	</c:if>
        	<c:if test="${empty sessionScope.sessionId}">
        		<a class="btn btn-outline" href="login.do">로그인</a>
        		<a class="btn" href="signUp.do">회원가입</a>
    		</c:if>
      	</nav>
    	</div>
  	</header>
</body>
</html>