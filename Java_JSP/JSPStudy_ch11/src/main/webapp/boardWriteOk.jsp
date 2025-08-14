<%@page import="com.gyojincompany.board.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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
	request.setCharacterEncoding("UTF-8");
	
	String title = request.getParameter("title");
	String bcontent = request.getParameter("bcontent");
	String memberid = request.getParameter("memberid");
	//DB삽입할 데이터 준비 완료
	
	//DB커넥션 준비
	String driverName = "com.mysql.cj.jdbc.Driver";	//mySQL jdbc 드라이버 이름
	String url = "jdbc:mysql://localhost:3306/jspdb";	//mySQL이 설치된 서버의 주소(ip)와 연결할 DB(스키마)의 이름
	//자신컴인 경우 localhost, 남의것인 경우 ip주소
	
	String username = "root";
	String password = "12345";
	
	//SQL문 만들기
	String insertSql = "INSERT INTO board(btitle, bcontent, memberid) VALUES('" + title + "', '" + bcontent + "', '" + memberid + "')";
	
	String selectSql = "SELECT * FROM board ORDER BY bnum DESC";
	
	Connection conn = null;	//커넥션 인터페이스로 선언 후 null로 초기값 설정
	Statement stmt = null;	//sql문을 관리해주는 객체를 선언해주는 인터페이스 stmt 선언
	ResultSet rs = null;	//select문 실행시 db에서 반환해주는 record 결과를 받아주는 자료타입 rs 선언
	//List<MemberDto> memberList = new ArrayList<MemberDto>();
	List<BoardDto> boardList = new ArrayList<BoardDto>();
	
	
	try {
		Class.forName(driverName);	//mySQL 드라이버 클래스 불러오기
	    conn = DriverManager.getConnection(url, username, password);
	    //커넥션 메모리 생성
	    stmt = conn.createStatement(); 	//stmt객체 생성
	    
	    int sqlResult = stmt.executeUpdate(insertSql);
	    
		rs = stmt.executeQuery(selectSql);
	    
		while(rs.next()) {
			BoardDto boardDto = new BoardDto();
			boardDto.setBnum(rs.getInt("bnum"));
			boardDto.setBtitle(rs.getString("btitle"));
			boardDto.setBcontent(rs.getString("bcontent"));
			boardDto.setMemberid(rs.getString("memberid"));
			boardDto.setBdate(rs.getString("bdate"));
			
			boardList.add(boardDto);
		}
		
		for(BoardDto mdto : boardList) {
			out.println(mdto.getBnum() + " / ");
			out.println(mdto.getBtitle() + " / ");
			out.println(mdto.getBcontent() + " / ");
			out.println(mdto.getMemberid() + " / ");
			out.println(mdto.getBdate() + "<br>");
		}
	    //select문 실행 -> 결과가 DB로부터 반환 -> 그 결과를 받아주는 ResultSet 타입 객체로 받아야함
	    
	} catch(Exception e) {
	    out.println("DB에러 게시글 조회 실패");
	    e.printStackTrace();
	} finally {	//에러 발생 여부와 상관 없이 커넥션 닫기
		try {
			if (rs != null) rs.close();
			if (stmt != null) stmt.close(); //stmt가 null이 아니면 닫기(커넥션보다 먼저 닫아줘야함)
			if (conn != null) conn.close(); //conn null이 아니면 닫기
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	%>
</body>
</html>