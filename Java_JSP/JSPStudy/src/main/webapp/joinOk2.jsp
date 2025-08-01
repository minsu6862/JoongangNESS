<%@page import="jdk.internal.org.jline.terminal.TerminalBuilder.SystemOutput"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Map"%>
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
		
		//취미 checkbox를 map자료 구조로 받기
		Map<String, String[]> hobby = request.getParameterMap();
		
		//취미 checkbox를 열거형 자료구조로 받기 -> 모든 파라미터의 이름만 가져오기
		Enumeration<String> hobbyEnum = request.getParameterNames();
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
		<li>취미1 : 
		<%
		String[] hobbys = hobby.get("hobby"); // 직접 "hobby" 키의 값을 가져오기
		if(hobbys == null || hobbys.length == 0) {
		    out.println("취미없음");
		} else {
		    for(int i = 0; i < hobbys.length; i++) {
		        out.print(hobbys[i]);
		        if(i < hobbys.length - 1) {
		            out.print(", ");
		        }
		    }
		}
		%>
		</li>
		<li>취미2 : 
		<%
		if(!hobbyEnum.hasMoreElements()) {
		    out.println("취미없음");
		} else {
			String[] hobby3 = null;
			while(hobbyEnum.hasMoreElements()) {
				String hobby2 = hobbyEnum.nextElement();
				if(hobby.equals("hobby")) {
					hobby3 = request.getParameterValues(hobby2);
				}
			}
		}
		%>
		</li>
		<li>자기소개 : <%= intro %></li>
	</ul>
	
</body>
</html>