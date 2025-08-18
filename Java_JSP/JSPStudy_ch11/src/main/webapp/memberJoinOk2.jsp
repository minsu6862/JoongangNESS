<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 처리</title>
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");
	
	String mid = request.getParameter("mid");
	String mpw = request.getParameter("mpw");
	String mname = request.getParameter("mname");
	String memail = request.getParameter("memail");
	//DB삽입할 데이터 준비 완료
	
	//DB커넥션 준비
	String driverName = "com.mysql.cj.jdbc.Driver";	//mySQL jdbc 드라이버 이름
	String url = "jdbc:mysql://localhost:3306/jspdb";	//mySQL이 설치된 서버의 주소(ip)와 연결할 DB(스키마)의 이름
	//자신컴인 경우 localhost, 남의것인 경우 ip주소
	
	String username = "root";
	String password = "12345";
	
	//SQL문 만들기
	String sql = "INSERT INTO members(memberid, memberpw, membername, memberemail) VALUES(?,?,?,?)";
	
	Connection conn = null;	//커넥션 인터페이스로 선언 후 null로 초기값 설정
	//Statement stmt = null;	//sql문을 관리해주는 객체를 선언해주는 인터페이스 stmt 선언
	PreparedStatement pstmt = null;
	
	try {
	    Class.forName(driverName);	//mySQL 드라이버 클래스 불러오기
	    conn = DriverManager.getConnection(url, username, password);
	    //커넥션 메모리 생성
	    //stmt = conn.createStatement(); 	//stmt객체 생성
	    pstmt = conn.prepareStatement(sql);
	    
	    pstmt.setString(1, mid);
	    pstmt.setString(2, mpw);
	    pstmt.setString(3, mname);
	    pstmt.setString(4, memail);
	    
	    //int sqlResult = pstmt.executeUpdate(sql);	//SQL문을 DB에서 실행 -> 성공하면 1 반환 실패면 1말고 다른값 반환
	    int sqlResult = pstmt.executeUpdate();	//SQL문을 DB에서 실행 -> 성공하면 1 반환 실패면 1말고 다른값 반환
	    
	    System.out.println("sqlresult : " + sqlResult);
	} catch(Exception e) {
	    out.println("DB에러 발생 회원가입 실패");
	    e.printStackTrace();
	} finally {	//에러 발생 여부와 상관 없이 커넥션 닫기
		try {
			if (pstmt != null) {	//stmt가 null이 아니면 닫기(커넥션보다 먼저 닫아줘야함)
				pstmt.close();
			}
			if (conn != null) {	//conn null이 아니면 닫기
				conn.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	%>
</body>
</html>