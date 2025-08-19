<%@page import="com.gyojincompany.dto.MemberDto"%>
<%@page import="com.gyojincompany.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정 완료</title>
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");
	
	String memberid = request.getParameter("memberid");
	String memberpw = request.getParameter("memberpw");
	String membername = request.getParameter("membername");
	int memberage = Integer.parseInt(request.getParameter("memberage"));
	String memberemail = request.getParameter("memberemail");
	
	MemberDao memberDao = new MemberDao();
	int UpdateResult = memberDao.updateMember(memberid, memberpw, membername, memberage, memberemail);
	
	if(UpdateResult == MemberDao.MEMBER_UPDATE_SUCCESS) {
		out.println("<script>alert('회원 수정 성공!');</script>");
		
		MemberDto memberDto = memberDao.getMemberInfo(memberid);
		
		request.setAttribute("memberDto", memberDto);
	} else {
		out.println("<script>alert('회원 수정 실패!');history.go(-1);</script>");
	}
	
	%>
	
	<h2>수정된 정보 확인</h2>
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