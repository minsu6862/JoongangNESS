package com.minsu.board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.minsu.board.dto.BoardDto;

public class BoardDao {
	private String driverName = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/springdb?serverTimezone=Asia/Seoul";
	private String username = "root";
	private String password = "12345";
	
	Connection connect = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void write(String board_name, String board_title, String board_content) {
		
		String sql = "INSERT INTO boardtbl(board_name, board_title, board_content, board_hit) VALUES (?, ?, ?, 1)";
		
		try {
			Class.forName(driverName);
			connect = DriverManager.getConnection(url, username, password);
			pstmt = connect.prepareStatement(sql);
		
			pstmt.setString(1, board_name);
			pstmt.setString(2, board_title);
			pstmt.setString(3, board_content);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(connect != null) connect.close();
				if(rs != null) rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<BoardDto> boardlist() {
		
		String sql = "SELECT * FROM boardtbl ORDER BY board_num DESC";
		List<BoardDto> boardDtos = new ArrayList<BoardDto>();
		BoardDto boardDto = null;  // 지역 변수로 선언
		
		try {
			Class.forName(driverName);
			connect = DriverManager.getConnection(url, username, password);
			pstmt = connect.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int board_num = rs.getInt("board_num");
				String board_title = rs.getString("board_title");
				String board_content = rs.getString("board_content");
				String board_name = rs.getString("board_name");
				int board_hit = rs.getInt("board_hit");
				String board_date = rs.getString("board_date");
				
				boardDto = new BoardDto(board_num, board_title, board_content, board_name, board_hit, board_date);
				
				boardDtos.add(boardDto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(connect != null) connect.close();
				if(rs != null) rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return boardDtos;
	}
	
	public BoardDto contentView(String board_num) {
		increaseHit(board_num);	//조회수 증가
		
		BoardDto boardDto = null;  // 지역 변수로 선언
		String sql = "SELECT * FROM boardtbl WHERE board_num = ?";
		
		try {
			Class.forName(driverName);
			connect = DriverManager.getConnection(url, username, password);
			pstmt = connect.prepareStatement(sql);
			
			pstmt.setString(1, board_num);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
	            int board_number = rs.getInt("board_num");
	            String board_title = rs.getString("board_title");
	            String board_content = rs.getString("board_content");
	            String board_name = rs.getString("board_name");
	            int board_hit = rs.getInt("board_hit");
	            String board_date = rs.getString("board_date");
	            
	            boardDto = new BoardDto(board_number, board_title, board_content, board_name, board_hit, board_date);
	        }
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(connect != null) connect.close();
				if(rs != null) rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return boardDto;
	}
	
	// 조회수 증가 메서드
	public void increaseHit(String board_num) {
	    String sql = "UPDATE boardtbl SET board_hit = board_hit + 1 WHERE board_num = ?";
	    
	    try {
	        Class.forName(driverName);
	        connect = DriverManager.getConnection(url, username, password);
	        pstmt = connect.prepareStatement(sql);
	        
	        pstmt.setString(1, board_num);
	        pstmt.executeUpdate();
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if(pstmt != null) pstmt.close();
	            if(connect != null) connect.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}
}
