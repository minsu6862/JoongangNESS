<%@page import="com.gyojincompany.dto.MemberDto"%>
<%@page import="com.gyojincompany.dao.MemberDao"%>
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
		//String mid = request.getParameter("memberid");
		//String mpw = request.getParameter("memberpw");
		//String mname = request.getParameter("membername");
		//int mage = Integer.parseInt(request.getParameter("memberage"));
		//String memail = request.getParameter("memberemail");
		
		//MemberDto memberDto = new MemberDto();
		//memberDto.setMemberid(mid);
		//memberDto.setMemberpw(mpw);
		//memberDto.setMembername(mname);
		//memberDto.setMemberage(mage);
		//memberDto.setMemberemail(memail);
		
		String deleteId = request.getParameter("deleteid");
		MemberDao memberDao = new MemberDao();
		
		int idCheck = memberDao.confirmId(deleteId);
		
		if(idCheck != MemberDao.MEMBER_ID_EXISTENT) { //이미 아이디 존재->가입불가
			out.println("<script>alert('회원 탈퇴 실패! 탈퇴하시려는 아이디가 존재하지 않습니다.');history.go(-1);</script>");	
		} else {
			int deleteResult = memberDao.deleteId(deleteId);
			
			if(deleteResult == MemberDao.MEMBER_DELETE_SUCCESS) {
				out.println("<script>alert('회원 탈퇴 성공!');</script>");
			} else {
				out.println("<script>alert('회원 탈퇴 실패!');history.go(-1);</script>");
			}
		}
	%>
</body>
</html>