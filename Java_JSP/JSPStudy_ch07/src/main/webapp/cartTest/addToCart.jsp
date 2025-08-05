<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니 상품 추가</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		
		String product = request.getParameter("product"); //장바구니에 추가할 상품 이름
		
		Cookie[] cookies = request.getCookies(); //기존 쿠키 가져오기
		
		String savedCart = "";
		String newCart = "";
		
		if(cookies != null) { //쿠키가 null값이 아닐때만->기존 쿠키 존재할때만->기존의 쿠키에 저장된 상품 목록
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("cart")) {
					savedCart = cookie.getValue(); //기존 장바구니에 있던 상품 목록
				}
			}
		}
		
		if(savedCart == "") {
			newCart = product; //노트북
		} else {
			newCart = savedCart + "/" + product; // 노트북/아이패드/스마트폰
		}		
		
		Cookie cartCookie = new Cookie("cart", newCart);
		cartCookie.setMaxAge(60*60*24*7); //7일 저장
		response.addCookie(cartCookie);
	
	%>
	<a href="productList.jsp">상품 추가하기</a><br><br>
	
	<a href="viewCart.jsp">장바구니 보기</a>
</body>
</html>