package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDao {
	private String driverName = "com.mysql.jdbc.Driver"; //MySQL JDBC 드라이버 이름
	private String url = "jdbc:mysql://localhost:3306/jspdb"; //MySQL이 설치된 서버의 주소(ip)와 연결할 DB(스키마) 이름		
	private String username = "root";
	private String password = "12345";	
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public int loginCheck(String memberid, String memberpw) {
		String sql = "SELECT * FROM members WHERE memberid = ? AND memberpw = ?";
		int sqlResult = 0;

	    try {
	        Class.forName(driverName);
	        conn = DriverManager.getConnection(url, username, password);
	        
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, memberid);
	        pstmt.setString(2, memberpw);
	        pstmt.executeQuery();
	        
	        rs = pstmt.executeQuery();
	        
	        if(rs.next()) {	//참이면 로그인 성공
	        	sqlResult = 1;
	        } else {	//로그인 실패
	        	sqlResult = 0;
	        }
	        
	    } catch (Exception e) {
	        System.out.println("DB 에러 발생! 회원 로그인 실패!");
	        e.printStackTrace();
	    } finally {
	        try {
	        	if(rs != null) rs.close();
	            if(pstmt != null) pstmt.close();
	            if(conn != null) conn.close();
	        } catch(Exception e) {
	            e.printStackTrace();
	        }
	    }
	    
	    return sqlResult;
	}
}
