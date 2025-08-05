<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품추가</title>
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");
	
	String product = request.getParameter("product");	//사용자가 장바구니에 넣을 제품
	
	//기존에 세션에 cart(ArrayList 타입) 존재하면 가져오기
	//첫번째 장바구니에 삽입시 cart -> 
	ArrayList<String> cart = (ArrayList<String>) session.getAttribute("cart");
	
	if (cart == null) {		//cart=null이면 새로 생성
		cart = new ArrayList<String>();
	}
	cart.add(product);
	session.setAttribute("cart", cart);
	%>
	
	<h2>장바구니에 <%= product %>이(가) 추가되었습니다.</h2>
	<a href="productList.jsp">장바구니 추가하기</a><br>
	<a href="viewCart.jsp">장바구니 확인하기</a>
</body>
</html>