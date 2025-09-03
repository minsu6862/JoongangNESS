package com.minsu.miniproject.dao;

import java.util.List;

import com.minsu.miniproject.dto.BoardDto;

public interface BoardDao {
		
	public int allBoardCount(); //게시판 모든 글 갯수 가져오기
	public List<BoardDto> pageBoardList(int startRow, int endRow);
	public void boardWrite(String title, String content, String writer);
	public void updateHit(String bnum); //해당 글의 조회수 1증가
	public BoardDto contentView(String bnum); //글 번호로 해당 글 레코드 가져오기
	public int boardModify(String bnum, String btitle, String bcontent);
	public int boardDelete(String bnum);
}
