<%@page import="java.util.Date"%>
<%@page import="com.gyojincompany.exer.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="student" class="com.gyojincompany.exer.Student" />
<jsp:useBean id="nowTime" class="java.util.Date" />        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 정보 출력</title>
</head>
<body>
	<%
		String name = request.getParameter("name");
		
		Student stu = new Student();
		stu.setName(name);
		
		Date nowtime2 = new Date();
		
		System.out.println(nowTime.toLocaleString());
	%>
	<jsp:setProperty property="*" name="student"/>	
	 
	<h2>학생 정보</h2>
	<hr>
	이 름 : <jsp:getProperty property="name" name="student"/><br>
	학 년 : <jsp:getProperty property="grade" name="student"/><br>
	나 이 : <jsp:getProperty property="age" name="student"/><br>
	학 번 : <jsp:getProperty property="hakbun" name="student"/><br>	
	<hr>
	<%= nowTime.toLocaleString() %>	
	<br><br>
	3 &lt; 10 &gt; 5 는 참이다.
</body>
</html>