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
  		int kor = Integer.parseInt(request.getParameter("kor"));
  		int eng = Integer.parseInt(request.getParameter("eng"));
  		int mat = Integer.parseInt(request.getParameter("mat"));
  		
  		double avg =(double) (kor + eng + mat) / 3;
	%>
	평균 점수는 : <%= avg %> 입니다.
</body>
</html>