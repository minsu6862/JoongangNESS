<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>tiger의 주문리스트</h2>
	<hr>
	<c:forEach items="${userOrderDtos }" var="ODto">
		주문번호 : ${ODto.order_id }<br>
		주문상품이름 : ${ODto.order_name }<br>
		<hr>
	</c:forEach>
</body>
</html>