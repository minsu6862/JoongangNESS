package com.minsu.miniproject.board;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.minsu.miniproject.DataNotFoundException;
import com.minsu.miniproject.member.Member;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardService {

	private final BoardRepository boardRepository;
	
	public List<Board> getList() {
		
		return boardRepository.findAll();
	}
	
	public Page<Board> getPageBoard(int page, String kw) {
		
		int size = 10;
		int startRow = page * size; //첫 페이지 page=0 -> 0*10 -> 0, 두번째 페이지 page=1 -> 10
		int endRow = startRow + size; //0+10 -> 10, 두번째 페이지 10 + 10 = 20
		
		List<Board> pageBoardList = boardRepository.findBoardWithPaging(startRow, endRow);
		long totalBoard = boardRepository.count();
		
		Page<Board> pagingList = new PageImpl<>(pageBoardList, PageRequest.of(page, size), totalBoard);
		
		return pagingList;
	}
	
	public void write(String subject, String content, Member member) {
		Board board = new Board();
		board.setSubject(subject);
		board.setContent(content);
		board.setCreateDate(LocalDateTime.now());
		board.setAuthor(member);
		
		boardRepository.save(board);
	}
	
	public void hit(Board board) {
		board.setHit(board.getHit()+1);
		boardRepository.save(board);
	}
	
	public Board getBoard(Integer id) {
		Optional<Board> OptionBoard = boardRepository.findById(id);
		
		if(OptionBoard.isPresent()) {
			return OptionBoard.get();
		} else {
			throw new DataNotFoundException("Board not found");
		}
	}
	
	public void modify(Board board, String subject, String content) {
		board.setSubject(subject);
		board.setContent(content);
		board.setModifyDate(LocalDateTime.now());
		boardRepository.save(board);
	}
	
	public void delete(Board board) {
		this.boardRepository.delete(board);
	}
}
