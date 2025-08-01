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
	request.setCharacterEncoding("utf-8");
	//20세 이상이면 성년, 아니면 미성년으로 출력, 단 성년 -> 빨간색,폰트사이즈30 미성년 -> 파랑색, 폰트사이즈 30으로 출력
	
	int age = Integer.parseInt(request.getParameter("age"));
	if(age >= 20) {
		//성년
	%>
	<span style="font-size: 30px; color: red">성년</span>
	<%
	
	} else {
		//미성년
	%>
	<span style="font-size: 30px; color: blue">미성년</span>
	<%
	
	}
	%>
</body>
</html>