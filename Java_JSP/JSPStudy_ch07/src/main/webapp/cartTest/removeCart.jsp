<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니 비우기</title>
</head>
<body>
	<%
	Cookie cookie = new Cookie("cart", "");
	cookie.setMaxAge(0);
	response.addCookie(cookie);
	%>
	<h2>장바구니가 비어졌습니다</h2>
	<a href="viewCart.jsp">장바구니 목록 보기</a>
	<a href="productList.jsp">상품 선택 페이지로 돌아가기</a>
</body>
</html>