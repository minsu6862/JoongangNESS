<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 장바구니</title>
</head>
<body>
	<h2>내 장바구니 상품 목록</h2>
	<hr>
	<%
	//세션에 들어있는 상품목록 cart 가져오기
	ArrayList<String> cart = (ArrayList<String>) session.getAttribute("cart");
	
	if(cart != null) {
		for(String product : cart) {
			out.println("* " + product + " <br>");
		}
	%>
	<a href="removeCart.jsp">장바구니 비우기</a>	
	<%
	} else {
		out.println("장바구니가 비어있습니다.");
	}
	%>
	
	<a href="productList.jsp">상품 선택 페이지로 돌아가기</a>
</body>
</html>