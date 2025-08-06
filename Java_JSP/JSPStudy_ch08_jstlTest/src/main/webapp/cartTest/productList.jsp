<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품목록</title>
</head>
<body>
	<h2>상품을 선택하세요.</h2>
	<hr>
	<form action="addToCart.jsp">
		상품종류 :
		<select name="product">
			<option value="무선이어폰">무선이어폰</option>
			<option value="노트북">노트북</option>
			<option value="스위치2">스위치2</option>
			<option value="갤럭시폴드7">갤럭시폴드7</option>
		</select>
		<br>
		상품색깔 : 
		<select name="color">
			<option value="블랙">블랙</option>
			<option value="실버">실버</option>
			<option value="스카이블루">스카이블루</option>
		</select>
		<br>
		상품수량 : <input type="text" name="quantity">
		<br>
		<input type="submit" value="장바구니에 담기">
	</form>
	<hr>
	<a href="viewCart.jsp">장바구니 보기</a>
</body>
</html>