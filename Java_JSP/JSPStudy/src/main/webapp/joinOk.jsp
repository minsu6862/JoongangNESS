<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 확인</title>
</head>
<body>
	<%
  		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		String memberName = request.getParameter("memberName");
		String memberAge = request.getParameter("memberAge");
		String gender = request.getParameter("gender");
		if(gender.equals("male")) {
			gender = "남자";
		} else {
			gender = "여자";
		}
		String memberEmail1 = request.getParameter("memberEmail1");
		String memberEmail2 = request.getParameter("memberEmail2");
		String[] hobby = request.getParameterValues("hobby");
		String intro = request.getParameter("intro");
	%>
	<h2>회원가입 정보</h2>
	<hr>
	<ul>
		<li>아이디 : <%= memberId %></li>
		<li>비밀번호 : <%= memberPw %></li>
		<li>이름 : <%= memberName %></li>
		<li>나이 : <%= memberAge %></li>
		<li>성별 : <%= gender %></li>
		<li>이메일 : <%= memberEmail1 %> @ <%= memberEmail2 %></li>
		<li>취미 : 
		<%
		if (hobby != null) {
		    for (String item : hobby) {
		        out.println(item + ", ");
		    }
		}
		%>
		</li>
		<li>자기소개 : <%= intro %></li>
	</ul>
	
</body>
</html>