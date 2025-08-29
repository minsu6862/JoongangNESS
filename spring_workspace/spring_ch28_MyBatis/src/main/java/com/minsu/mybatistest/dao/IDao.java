package com.minsu.mybatistest.dao;

import java.util.List;

import com.minsu.mybatistest.dto.BoardDto;

public interface IDao {

	//모든 글 리스트 불러오기 추상 메서드 선언
	public List<BoardDto> boardlistDao();
	
	//게시판 글쓰기 추상 메서드 선언
	public void boardWriteDao(BoardDto boardDto);
	
	//게시글 삭제 추상 메서드
	public void boardDeleteDao(String board_num);
	
	//게시판 모든 글 수 가져오기 추상 메서드 선언
	public int boardCountDao();
	
	//선택한 게시글 보기 메서드
	public BoardDto contentViewDao(String board_num);
	
	//게시글 수정 메서드
	public void boardUpdateDao(BoardDto boardDto);
}
