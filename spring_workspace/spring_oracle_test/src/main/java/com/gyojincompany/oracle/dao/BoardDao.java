package com.gyojincompany.oracle.dao;

import java.util.List;

import com.gyojincompany.oracle.dto.BoardDto;

public interface BoardDao {
	
	public void boardWriteDao(String btitle, String bcontent, String bwriter); //게시판 글쓰기
	public List<BoardDto> boardListDao(); //게시판 글 목록 보기
	public int AllBoardCountDao(); //게시판 모든 글 갯수 가져오기
	public int boardDeleteDao(String bnum); //게시판 글 삭제
	
}