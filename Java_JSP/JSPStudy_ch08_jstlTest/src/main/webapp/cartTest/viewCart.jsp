<%@page import="com.dto.ProductDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	* {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
   	}
   	table {
        border-collapse: collapse;
    }
    th, td {
    	border: 1px solid black;
    	padding: 8px;
    	text-align: center;
	}
</style>
</head>
<body>
	<!-- 게시판 글 리스트 -->
	<%
	List<ProductDto> cartList = (List<ProductDto>)session.getAttribute("productList");
	
	request.setAttribute("cartList", cartList);
	%>
	<h2>장바구니 목록</h2>
	<hr>
	<table>
		<tr>
			<th>번호</th>
			<th>상품종류</th>
			<th>색깔</th>
			<th>수량</th>
		</tr>
		
		<c:forEach var="productDto" items="${cartList }" varStatus="status">
			<tr>
				<td>${status.count}</td>
				<td>${productDto.pName }</td>
				<td>${productDto.pColor }</td>
				<td>${productDto.pQtt }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>