<%@page import="com.gyojincompany.dto.MemberDto"%>
<%@page import="com.gyojincompany.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
</head>
<body>
	<%
	String sid = (String) session.getAttribute("sessionId");
	if(sid == null) {	//세션에 sessionId값이 없으면 로그인 하지 않고 본 페이지로 방문했다고 판단
		out.println("<script>alert('로그인 하지 않은 유저는 해당 페이지 접근 불가');window.location.href='loginMember.jsp';<script>");
	} else {
		MemberDao memberDao = new MemberDao();
		MemberDto memberDto = memberDao.getMemberInfo(sid);
		
		request.setAttribute("memberDto", memberDto);
	}
	
	%>
	<h2>회원 정보 수정</h2>
	<hr>
	<form action="modifyMemberOk.jsp" method="post">
		아이디 : <input type="text" name="memberid" value="${memberDto.memberid }"><br><br>
		비밀번호 : <input type="password" name="memberpw" value="${memberDto.memberpw }"><br><br>
		이름 : <input type="text" name="membername" value="${memberDto.membername }"><br><br>
		나이 : <input type="text" name="memberage" value="${memberDto.memberage }"><br><br>
		이메일 : <input type="text" name="memberemail" value="${memberDto.memberemail }"><br><br>
		등록일 : <input type="text" name="memberdate" value="${memberDto.memberdate }" readonly><br><br>
		<input type="submit" value="수정완료">
	</form>
</body>
</html>