<%@page import="com.dto.ProductDto"%>
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
	
	String product = request.getParameter("product");
	String color = request.getParameter("color");
	String quantityStr = request.getParameter("quantity");

	int quantity = 0;
	try {
	    quantity = Integer.parseInt(quantityStr);
	} catch (NumberFormatException e) {
	    quantity = 1;
	}
	
	List<ProductDto> productList = (List<ProductDto>) session.getAttribute("productList");
	
	if (productList == null) {		//productList=null이면 새로 생성
		productList = new ArrayList<ProductDto>();
	}
	ProductDto newProduct = new ProductDto(product, color, quantity);
	productList.add(newProduct);
	session.setAttribute("productList", productList);
	%>
	
	<h2>장바구니에 <%= product %>이(가) <%= quantity %>개 추가되었습니다.</h2>
	<a href="productList.jsp">장바구니 추가하기</a><br>
	<a href="viewCart.jsp">장바구니 확인하기</a>
</body>
</html>