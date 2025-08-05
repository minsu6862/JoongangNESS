<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니 보기</title>
</head>
<body>
	<%
		Cookie[] cookies = request.getCookies();
		
		String savedCart = "";
	
		if(cookies != null) { //쿠키가 null값이 아닐때만->기존 쿠키 존재할때만->기존의 쿠키에 저장된 상품 목록
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("cart")) {
					savedCart = cookie.getValue(); //기존 장바구니에 있던 상품 목록
				}
			}
		}
		
		if (savedCart == null) {
			out.println("장바구니가 비어 있습니다.");
		} else {
			//out.println(savedCart); //상품 목록 출력
			String[] carts = savedCart.split("/");
			for(String cart : carts) {
				out.println("* " + cart + "<br>");
			}
		}
	%>
	<a href="removeCart.jsp">장바구니 비우기</a>
</body>
</html>