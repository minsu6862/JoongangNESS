<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 확인</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
	
		String mid = request.getParameter("loginId");
		String mpw = request.getParameter("loginPw");
		String rememberId = request.getParameter("rememberId"); //아이디 저장 체크박스 값
		//System.out.println(rememberId);
		
		if(mid.equals("tiger") && mpw.equals("12345")) { //참이면 로그인 성공
			if(rememberId != null) { //참이면 체크박스에 체크가 된 상태로 넘어옴
				Cookie cookie = new Cookie("saveId", mid); //쿠키에 saveId -> tiger 생성
				Cookie cookie2 = new Cookie("savePw", mpw); //쿠키에 savePw -> 12345 생성
				cookie.setMaxAge(60*60*24*7); //7일 동안 쿠키 유지
				cookie2.setMaxAge(60*60*24*7); //7일 동안 쿠키 유지
				response.addCookie(cookie); //쿠키를 클라이언트에게 보내기
				response.addCookie(cookie2); //쿠키를 클라이언트에게 보내기
			} else { //체크박스를 체크가 안한 상태로 넘어옴->쿠키 삭제->자동 로그인 풀림 
				Cookie cookie = new Cookie("saveId", ""); //쿠키에 saveId만 생성
				Cookie cookie2 = new Cookie("savePw", ""); //쿠키에 savePw만 생성
				cookie.setMaxAge(0); //쿠키 삭제
				cookie2.setMaxAge(0); //쿠키 삭제
				response.addCookie(cookie); //쿠키를 클라이언트에게 보내기 
				response.addCookie(cookie2); //쿠키를 클라이언트에게 보내기
			}			
			
			session.setAttribute("user", mid);
			response.sendRedirect("welcome.jsp"); //로그인 성공시 welcome 페이지로 강제 이동
		} else {
			response.sendRedirect("login.jsp"); //로그인 실패시 login 페이지로 강제 이동
		}
	%>
</body>
</html>