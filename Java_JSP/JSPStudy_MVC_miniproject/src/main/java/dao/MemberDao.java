package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dto.MemberDto;

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
	
	public void signUpMember (String id, String pw, String name, String email) {
		String sql ="INSERT INTO members(memberid, memberpw, membername, memberemail) VALUES (?, ?, ?, ?)";
		
		try {
			Class.forName(driverName); //MySQL 드라이버 클래스 불러오기			
			conn = DriverManager.getConnection(url, username, password);
			//커넥션이 메모리 생성(DB와 연결 커넥션 conn 생성)
			
			pstmt = conn.prepareStatement(sql); //pstmt 객체 생성(sql 삽입)
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			
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
	
	public int signUpChek(String id) {
		String sql = "SELECT memberid FROM members WHERE memberid = ?";
		
		try {
			Class.forName(driverName); //MySQL 드라이버 클래스 불러오기			
			conn = DriverManager.getConnection(url, username, password);
			//커넥션이 메모리 생성(DB와 연결 커넥션 conn 생성)
			
			pstmt = conn.prepareStatement(sql); //pstmt 객체 생성(sql 삽입)
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
	            return 1; // 중복된 아이디가 존재함
	        } else {
	            return 0; // 사용 가능한 아이디
	        }
			
		} catch (Exception e) {
			System.out.println("DB 에러 발생! 게시판 목록 불러오기 실패!");
			e.printStackTrace(); //에러 내용 출력
			return -1; // DB 에러 발생
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
	}
	
	public MemberDto MyPageView(String memberId) {
		String sql = "SELECT * FROM MEMBERS WHERE memberid = ?";
		MemberDto memberDto = null;
		
		try {
			Class.forName(driverName); //MySQL 드라이버 클래스 불러오기			
			conn = DriverManager.getConnection(url, username, password);
			//커넥션이 메모리 생성(DB와 연결 커넥션 conn 생성)
	        
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, memberId);
	        rs = pstmt.executeQuery();
			
			if(rs.next()) {
	            String memberid = rs.getString("memberid");
	            String memberpw = rs.getString("memberpw");
	            String membername = rs.getString("membername");
	            String memberemail = rs.getString("memberemail");
	            String memberdate = rs.getString("memberdate");
	            
	            // 올바른 순서로 memberDto 생성
	            memberDto = new MemberDto(memberid, memberpw, membername, memberemail, memberdate);
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
		return memberDto; //글(bDto) 여러개가 담긴 list인 bDtos를 반환
	}
	
	public int memberUpdate(String memberid, String memberpw, String membername, String memberemail) {
		String sql = "UPDATE members SET membername = ?, memberemail = ? WHERE memberid = ? AND memberpw = ?";
		int result = 0;
		
		try {
			Class.forName(driverName); //MySQL 드라이버 클래스 불러오기			
			conn = DriverManager.getConnection(url, username, password);
			//커넥션이 메모리 생성(DB와 연결 커넥션 conn 생성)
			
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, membername);
	        pstmt.setString(2, memberemail);
	        pstmt.setString(3, memberid);
	        pstmt.setString(4, memberpw);
	        
	        result = pstmt.executeUpdate(); // 영향받은 행의 수 반환
	        System.out.println("회원정보 수정 결과: " + result + "행 수정됨");
			
		} catch (Exception e) {
			System.out.println("DB 에러 발생! 게시판 수정 실패!");
			e.printStackTrace(); //에러 내용 출력
			result = 0;
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
		return result;
	}
	
}
