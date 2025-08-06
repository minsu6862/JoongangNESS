<%@page import="java.util.ArrayList"%>
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
	//1. JSP에서 선언 없이 세션 객체를 얻을 수 있는 이유는 무엇인가?
	session = request.getSession();
	
	//2. 쿠키 객체의 값을 아래와 같이 입력하여 생성하는 코드 한 줄로 작성하세요. 
	Cookie cookie = new Cookie("user", "hong");
	
	//3. 세션에 사용자 이름("name")과 값 ("홍길동")을 저장하는 코드를 작성하세요.
	session.setAttribute("name", "홍길동");
	
	//4. 세션에서 저장된 이름("name")을 가져오는 코드를 작성하세요.
	String sid = (String) session.getAttribute("name");
	
	//5. 쿠키를 클라이언트에게 전송하려면 어떤 객체를 사용하나요?
	response.addCookie(cookie);
	
	//6. 브라우저가 닫히면 삭제되는 쿠키는 어떤 값으로 만료시간을 설정해야 하나요?
	cookie.setMaxAge(-1);
	
	//7. 세션을 무효화(삭제)하는 메서드는?
	session.removeAttribute("name");
	session.invalidate();
	
	//8. 쿠키를 즉시 삭제하려면 어떻게 해야 하나요?
	cookie.setMaxAge(0);
	
	//9. JSP에서 모든 쿠키를 얻는 코드 한 줄 작성하세요.
	Cookie[] cookies = request.getCookies();
	
	//10. 쿠키 배열에서 "user"라는 이름의 쿠키 값을 출력하는 코드를 작성하세요.
	for(Cookie cookie2 : cookies) {
		if(cookie2.equals("user")) {
			cookie2.getValue();
		}
	}
	
	//11.  쿠키에 사용자 ID를 7일간 저장하려면 어떻게 해야 하나요?
	cookie.setMaxAge(60*60*24*7);
			
	//12. JSP에서 세션 타임아웃 시간을 30분으로 설정하는 코드를 작성하세요.
	session.setMaxInactiveInterval(60*30);
	
	//13. JSP 페이지에서 쿠키의 이름과 값을 모두 출력하는 코드를 작성하세요.
	for(Cookie cookie2 : cookies) {
		out.println(cookie2.getName() + "<br>");
		out.println(cookie2.getValue() + "<br>");
	}
	
	//14. 세션에서 "cart"라는 이름으로 저장된 ArrayList를 가져오는 코드 작성
	ArrayList<String> cart = (ArrayList<String>) session.getAttribute("cart");
	
	//15. 세션과 쿠키의 차이점을 간단히 정리하시오.
	//세션 - 서버 메모리에 저장, 서버에 저장되므로 상대적으로 안전함, 브라우저 종료시 삭제
	//쿠키 - 클라이언트(브라우저)에 저장, 클라이언트에게 저장되므로 탈취될 가능성 존재, 메모리가 4kb로 제한, 만료일을 설정해 브라우저를 종료해도 삭제되지 않게 할 수 있음
	
	
	%>
</body>
</html>