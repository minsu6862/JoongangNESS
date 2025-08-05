<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 유효시간 설정</title>
</head>
<body>
	<%
	Cookie[] cookies = request.getCookies();
	for(Cookie cookie : cookies) {
		cookie.setMaxAge(60);	//쿠키의 유효시간 설정 7일로 변경
		response.addCookie(cookie);	//클라이언트한테 바뀐 쿠키 보내기
	}
	
	for(Cookie cookie : cookies) {	//모든 쿠키 삭제
		cookie.setMaxAge(0);	//쿠키의 유효시간 설정 0으로 설정시 삭제
		response.addCookie(cookie);
	}
	%>
</body>
</html> 