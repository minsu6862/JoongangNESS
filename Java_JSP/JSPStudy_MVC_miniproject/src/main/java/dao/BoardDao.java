package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.BoardDto;
import dto.BoardMemberDto;
import dto.MemberDto;

public class BoardDao {
	private String driverName = "com.mysql.jdbc.Driver"; //MySQL JDBC 드라이버 이름
	private String url = "jdbc:mysql://localhost:3306/jspdb"; //MySQL이 설치된 서버의 주소(ip)와 연결할 DB(스키마) 이름		
	private String username = "root";
	private String password = "12345";	
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	public static final int PAGE_SIZE = 10;
	
	public List<BoardDto> boardList(int page) {
		//String sql = "SELECT * FROM board ORDER BY bnum DESC";
		int offset = (page - 1) * PAGE_SIZE;
		String sql = "SELECT b.bnum, b.btitle, b.bcontent, b.memberid, " +
                "COALESCE(m.memberemail, '탈퇴한회원') as memberemail, b.bdate, b.bhit " +
                "FROM board b LEFT JOIN members m ON b.memberid = m.memberid " +
                "ORDER BY bnum DESC " +
                "LIMIT " + PAGE_SIZE + " OFFSET " + offset;
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
				String memberemail = rs.getString("memberemail");
				int bhit = rs.getInt("bhit");
				String bdate = rs.getString("bdate");
				
				MemberDto memberDto = new MemberDto();
				memberDto.setMemberid(memberid);
				memberDto.setMemberemail(memberemail);
				//BoardDto bDto = new BoardDto(bnum, btitle, bcontent, memberid, bhit, bdate);
				//BoardMemberDto bmDto = new BoardMemberDto(bnum, btitle, bcontent, memberid, memberemail, bhit, bdate);
				BoardDto bDto = new BoardDto(bnum, btitle, bcontent, memberid, bhit, bdate, memberDto);
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
	
	//게시글 검색 기능
	public List<BoardDto> searchBoardList(String searchType, String searchKeyword, int page) {
		String whereClause = "";
		
		// 검색 타입에 따라 WHERE 절 구성
	    switch(searchType) {
	        case "title":
	            whereClause = "WHERE b.btitle LIKE ?";
	            break;
	        case "content":
	            whereClause = "WHERE b.bcontent LIKE ?";
	            break;
	        case "writer":
	            whereClause = "WHERE b.memberid LIKE ?";
	            break;
	        default:
	            whereClause = "WHERE b.btitle LIKE ?";
	    }
	    
	    // 페이징 계산 추가
	    int offset = (page - 1) * PAGE_SIZE;
	    
		//String sql = "SELECT * FROM board ORDER BY bnum DESC";
		String sql = "SELECT b.bnum, b.btitle, b.bcontent, b.memberid, " +
                "COALESCE(m.memberemail, '탈퇴한회원') as memberemail, b.bdate, b.bhit " +
                "FROM board b LEFT JOIN members m ON b.memberid = m.memberid " +
                whereClause + " " + 
                "ORDER BY bnum DESC " +
                "LIMIT " + PAGE_SIZE + " OFFSET " + offset;
		List<BoardDto> bDtos = new ArrayList<BoardDto>();
		
		try {
			Class.forName(driverName); //MySQL 드라이버 클래스 불러오기			
			conn = DriverManager.getConnection(url, username, password);
			//커넥션이 메모리 생성(DB와 연결 커넥션 conn 생성)
			
			pstmt = conn.prepareStatement(sql); //pstmt 객체 생성(sql 삽입)
			pstmt.setString(1, "%" + searchKeyword + "%");
			
			rs = pstmt.executeQuery();		
			
			while(rs.next()) {
				int bnum = rs.getInt("bnum");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				String memberid = rs.getString("memberid");
				String memberemail = rs.getString("memberemail");
				int bhit = rs.getInt("bhit");
				String bdate = rs.getString("bdate");
				
				MemberDto memberDto = new MemberDto();
				memberDto.setMemberid(memberid);
				memberDto.setMemberemail(memberemail);
				//BoardDto bDto = new BoardDto(bnum, btitle, bcontent, memberid, bhit, bdate);
				//BoardMemberDto bmDto = new BoardMemberDto(bnum, btitle, bcontent, memberid, memberemail, bhit, bdate);
				BoardDto bDto = new BoardDto(bnum, btitle, bcontent, memberid, bhit, bdate, memberDto);
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
		String sql = "SELECT b.bnum, b.btitle, b.bcontent, b.memberid, COALESCE(m.memberemail, '탈퇴한회원') as memberemail, b.bdate, b.bhit FROM board b LEFT JOIN members m ON b.memberid = m.memberid WHERE bnum = ?";
		BoardDto boardDto = null;
		
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
	            String memberemail = rs.getString("memberemail");
	            
	            MemberDto memberDto = new MemberDto();
				memberDto.setMemberid(memberid);
				memberDto.setMemberemail(memberemail);
	            
	            // 올바른 순서로 BoardDto 생성
	            boardDto = new BoardDto(bnumInt, btitle, bcontent, memberid, bhit, bdate, memberDto);
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
	
	// 1. 게시글 삭제 메서드
	public void boardDelete(String bnum) {
	    String sql = "DELETE FROM board WHERE bnum = ?";
	    
	    try {
	        Class.forName(driverName);
	        conn = DriverManager.getConnection(url, username, password);
	        
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, bnum);
	        pstmt.executeUpdate();
	        
	        // 삭제 후 번호 재정렬 호출
	        reorderBoardNumbers();
	        
	    } catch (Exception e) {
	        System.out.println("DB 에러 발생! 게시글 삭제 실패!");
	        e.printStackTrace();
	    } finally {
	        try {
	            if(pstmt != null) pstmt.close();
	            if(conn != null) conn.close();
	        } catch(Exception e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	// 2. 번호 재정렬 메서드
	public void reorderBoardNumbers() {
	    try {
	        Class.forName(driverName);
	        conn = DriverManager.getConnection(url, username, password);
	        
	        // 임시 테이블 생성 및 데이터 복사
	        String createTempSql = "CREATE TEMPORARY TABLE temp_board AS " +
	                              "SELECT btitle, bcontent, memberid, bhit, bdate " +
	                              "FROM board ORDER BY bnum";
	        pstmt = conn.prepareStatement(createTempSql);
	        pstmt.executeUpdate();
	        pstmt.close();
	        
	        // 기존 테이블 비우기
	        String truncateSql = "TRUNCATE TABLE board";
	        pstmt = conn.prepareStatement(truncateSql);
	        pstmt.executeUpdate();
	        pstmt.close();
	        
	        // AUTO_INCREMENT 1로 초기화
	        String resetAutoSql = "ALTER TABLE board AUTO_INCREMENT = 1";
	        pstmt = conn.prepareStatement(resetAutoSql);
	        pstmt.executeUpdate();
	        pstmt.close();
	        
	        // 임시 테이블에서 다시 삽입 (자동으로 1,2,3,4... 순서가 됨)
	        String insertSql = "INSERT INTO board (btitle, bcontent, memberid, bhit, bdate) " +
	                          "SELECT btitle, bcontent, memberid, bhit, bdate FROM temp_board";
	        pstmt = conn.prepareStatement(insertSql);
	        pstmt.executeUpdate();
	        
	    } catch (Exception e) {
	        System.out.println("DB 에러 발생! 번호 재정렬 실패!");
	        e.printStackTrace();
	    } finally {
	        try {
	            if(pstmt != null) pstmt.close();
	            if(conn != null) conn.close();
	        } catch(Exception e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	public void boardUpdate(String bnum, String btitle, String bcontent) {
		String sql = "UPDATE board SET btitle = ?, bcontent = ? WHERE bnum = ?";
		
		try {
			Class.forName(driverName); //MySQL 드라이버 클래스 불러오기			
			conn = DriverManager.getConnection(url, username, password);
			//커넥션이 메모리 생성(DB와 연결 커넥션 conn 생성)
			
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, btitle);
	        pstmt.setString(2, bcontent);
	        pstmt.setString(3, bnum);
	        
	        pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("DB 에러 발생! 게시판 수정 실패!");
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
	
	public int countBoard() {	//게시판 모든 글의 개수를 반환하는 메소드
		String sql = "SELECT COUNT(*) FROM board";
		
		//String sql = "SELECT * FROM board ORDER BY bnum DESC"; 
		int count = 0;
		
		try {
			Class.forName(driverName); //MySQL 드라이버 클래스 불러오기			
			conn = DriverManager.getConnection(url, username, password);
			//커넥션이 메모리 생성(DB와 연결 커넥션 conn 생성)
			
			pstmt = conn.prepareStatement(sql); //pstmt 객체 생성(sql 삽입)
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
	            count = rs.getInt(1); // 첫 번째 컬럼(COUNT(*) 결과)를 가져옴
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
		return count; //글(bDto) 여러개가 담긴 list인 bDtos를 반환
	}
	
	//검색 결과 게시글 갯수 조회 메서드
	public int countSearchBoard(String searchType, String searchKeyword) {
	    String whereClause = "";
	    
	    // 검색 타입에 따라 WHERE 절 구성
	    switch(searchType) {
	        case "title":
	            whereClause = "WHERE b.btitle LIKE ?";
	            break;
	        case "content":
	            whereClause = "WHERE b.bcontent LIKE ?";
	            break;
	        case "writer":
	            whereClause = "WHERE b.memberid LIKE ?";
	            break;
	        default:
	            whereClause = "WHERE b.btitle LIKE ?";
	    }
	    
	    String sql = "SELECT COUNT(*) FROM board b LEFT JOIN members m ON b.memberid = m.memberid " + whereClause;
	    int count = 0;
	    
	    try {
	        Class.forName(driverName);
	        conn = DriverManager.getConnection(url, username, password);
	        
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, "%" + searchKeyword + "%");
	        
	        rs = pstmt.executeQuery();
	        
	        if(rs.next()) {
	            count = rs.getInt(1);
	        }
	        
	    } catch (Exception e) {
	        System.out.println("DB 에러 발생! 검색 게시글 수 조회 실패!");
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
	    return count;
	}
	
}
