package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.BoardDto;

public class BoardDao {
	private String driverName = "com.mysql.jdbc.Driver"; //MySQL JDBC 드라이버 이름
	private String url = "jdbc:mysql://localhost:3306/jspdb"; //MySQL이 설치된 서버의 주소(ip)와 연결할 DB(스키마) 이름		
	private String username = "root";
	private String password = "12345";	
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;	
	
	public List<BoardDto> boardList() {
		String sql = "SELECT * FROM board ORDER BY bnum DESC";
		BoardDto boardDto = new BoardDto();
		List<BoardDto> bDtos = new ArrayList<BoardDto>();
		
		try {
			Class.forName(driverName); //MySQL 드라이버 클래스 불러오기			
			conn = DriverManager.getConnection(url, username, password);
			//커넥션이 메모리 생성(DB와 연결 커넥션 conn 생성)
			
			pstmt = conn.prepareStatement(sql); //pstmt 객체 생성(sql 삽입)
			
			rs = pstmt.executeQuery();		
			
			while(rs.next()) {
				int bnum = rs.getInt("bnum");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				String memberid = rs.getString("memberid");
				int bhit = rs.getInt("bhit");
				String bdate = rs.getString("bdate");
				
				BoardDto bDto = new BoardDto(bnum, btitle, bcontent, memberid, bhit, bdate);
				bDtos.add(bDto);
			}
			
		} catch (Exception e) {
			System.out.println("DB 에러 발생! 게시판 목록 불러오기 실패!");
			e.printStackTrace(); //에러 내용 출력
		} finally { //에러의 발생여부와 상관 없이 Connection 닫기 실행 
			try {
				if(rs != null) { //rs가 null 이 아니면 닫기(stmt 닫기 보다 먼저 실행)
					rs.close();
				}				
				if(pstmt != null) { //stmt가 null 이 아니면 닫기(conn 닫기 보다 먼저 실행)
					pstmt.close();
				}				
				if(conn != null) { //Connection이 null 이 아닐 때만 닫기
					conn.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return bDtos; //글(bDto) 여러개가 담긴 list인 bDtos를 반환
	}
	
	public void boardWrite(String btitle, String bcontent, String memberid) {
		String sql ="INSERT INTO board(btitle, bcontent, memberid, bhit) VALUES (?, ?, ?, 0)";
		
		try {
			Class.forName(driverName); //MySQL 드라이버 클래스 불러오기			
			conn = DriverManager.getConnection(url, username, password);
			//커넥션이 메모리 생성(DB와 연결 커넥션 conn 생성)
			
			pstmt = conn.prepareStatement(sql); //pstmt 객체 생성(sql 삽입)
			pstmt.setString(1, btitle);
			pstmt.setString(2, bcontent);
			pstmt.setString(3, memberid);
			
			pstmt.executeUpdate(); //성공하면 sqlResult 값이 1로 변환
			// SQL문을 DB에서 실행->성공하면 1이 반환, 실패면 1이 아닌 값 0이 반환
			
			
		} catch (Exception e) {
			System.out.println("DB 에러 발생! 글쓰기 실패!");
			e.printStackTrace(); //에러 내용 출력
		} finally { //에러의 발생여부와 상관 없이 Connection 닫기 실행 
			try {
				if(pstmt != null) { //stmt가 null 이 아니면 닫기(conn 닫기 보다 먼저 실행)
					pstmt.close();
				}				
				if(conn != null) { //Connection이 null 이 아닐 때만 닫기
					conn.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public BoardDto ContentView(String bnum) {
		String updateHitSql = "UPDATE board SET bhit = bhit + 1 WHERE bnum = ?";
		String sql = "SELECT * FROM board WHERE bnum = ?";
		BoardDto boardDto = new BoardDto();
		
		try {
			Class.forName(driverName); //MySQL 드라이버 클래스 불러오기			
			conn = DriverManager.getConnection(url, username, password);
			//커넥션이 메모리 생성(DB와 연결 커넥션 conn 생성)
			
			// 조회수 증가
	        pstmt = conn.prepareStatement(updateHitSql);
	        pstmt.setString(1, bnum);
	        pstmt.executeUpdate();
	        pstmt.close();
	        
	        // 게시글 조회
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, bnum);
	        rs = pstmt.executeQuery();
			
			if(rs.next()) {
	            int bnumInt = rs.getInt("bnum");    // bnum 값 가져오기
	            String btitle = rs.getString("btitle");
	            String bcontent = rs.getString("bcontent");
	            String memberid = rs.getString("memberid");
	            int bhit = rs.getInt("bhit");
	            String bdate = rs.getString("bdate");
	            
	            // 올바른 순서로 BoardDto 생성
	            boardDto = new BoardDto(bnumInt, btitle, bcontent, memberid, bhit, bdate);
	        }
			
		} catch (Exception e) {
			System.out.println("DB 에러 발생! 게시판 목록 불러오기 실패!");
			e.printStackTrace(); //에러 내용 출력
		} finally { //에러의 발생여부와 상관 없이 Connection 닫기 실행 
			try {
				if(rs != null) { //rs가 null 이 아니면 닫기(stmt 닫기 보다 먼저 실행)
					rs.close();
				}				
				if(pstmt != null) { //stmt가 null 이 아니면 닫기(conn 닫기 보다 먼저 실행)
					pstmt.close();
				}				
				if(conn != null) { //Connection이 null 이 아닐 때만 닫기
					conn.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return boardDto; //글(bDto) 여러개가 담긴 list인 bDtos를 반환
	}
}
