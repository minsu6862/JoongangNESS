<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	try {
		int a = 10;
		int b = 0;
		
		out.println(a / b);	
	} catch (Exception e) {
		e.printStackTrace();
		out.println("에러 내용 : " + e.getMessage());
	}
	
	%>
</body>
</html>