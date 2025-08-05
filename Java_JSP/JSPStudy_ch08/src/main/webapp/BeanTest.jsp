<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="stu1" class="com.gyojincompany.exer.Student" />    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:setProperty property="name" name="stu1" value="홍길동" />
	<jsp:setProperty property="grade" name="stu1" value="3" />
	<jsp:setProperty property="age" name="stu1" value="17" />
	<jsp:setProperty property="hakbun" name="stu1" value="240805" />
	
	<h2>학생 정보</h2>
	<hr>
	이 름 : <jsp:getProperty property="name" name="stu1"/><br>
	학 년 : <jsp:getProperty property="grade" name="stu1"/><br>
	나 이 : <jsp:getProperty property="age" name="stu1"/><br>
	학 번 : <jsp:getProperty property="hakbun" name="stu1"/><br>
</body>
</html>