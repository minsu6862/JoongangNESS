<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 성공</title>
</head>
<body>
	<%
	//쿠키에 저장된 값 가져오기
	Cookie[] cookies = request.getCookies();
	
	for(Cookie c : cookies) {
		String cValue = c.getValue();
		if(cValue.equals("tiger")) {
			out.println(cValue + "님 오신것을 환영합니다.");
		}
	}
	%>
</body>
</html>