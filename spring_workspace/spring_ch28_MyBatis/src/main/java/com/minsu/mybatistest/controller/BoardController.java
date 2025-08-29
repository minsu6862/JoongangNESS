package com.minsu.mybatistest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.minsu.mybatistest.dao.IDao;
import com.minsu.mybatistest.dto.BoardDto;

@Controller
public class BoardController {
	
	@Autowired
	private SqlSession sqlSession;	//DI(의존성 자동 주입)
	
	@RequestMapping(value = "/boardlist")
	public String boardlist(HttpServletRequest request, Model model) {
		IDao iDao = sqlSession.getMapper(IDao.class);
		List<BoardDto> boardDtos =  iDao.boardlistDao();
		
		model.addAttribute("boardDtos", boardDtos);
		
		return "boardlist";
	}
	
	// 게시판 글쓰기 폼 페이지로 이동
	@RequestMapping(value = "/boardwrite", method = RequestMethod.GET)
	public String boardwriteForm() {
		return "boardwrite";  // boardwrite.jsp로 이동
	}
	
	@RequestMapping(value = "/boarddelete")
	public String delete_form() {
		return "deleteForm";
	}
		
	// 게시판 글쓰기 처리
	@RequestMapping(value = "/boardwrite", method = RequestMethod.POST)
	public String boardwrite(HttpServletRequest request, Model model) {
		String board_title = request.getParameter("board_title");
		String board_content = request.getParameter("board_content");
		String board_name = request.getParameter("board_name");
			
		// BoardDto 객체 생성 및 데이터 설정
		BoardDto boardDto = new BoardDto();
		boardDto.setBoard_title(board_title);
		boardDto.setBoard_content(board_content);
		boardDto.setBoard_name(board_name);
			
		// 데이터베이스에 저장
		IDao iDao = sqlSession.getMapper(IDao.class);
		iDao.boardWriteDao(boardDto);
			
		// 글쓰기 완료 후 목록 페이지로 리다이렉트
		return "redirect:boardlist";
	}
	
	@RequestMapping(value = "/deleteOk")
	public String boardDelete(HttpServletRequest request, Model model) {
		String board_num = request.getParameter("board_num");
		
		IDao iDao = sqlSession.getMapper(IDao.class);
		iDao.boardDeleteDao(board_num);
		
		return "redirect:/boardlist";
	}
	
	@RequestMapping(value = "/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		String board_num = request.getParameter("board_num");
		
		IDao iDao = sqlSession.getMapper(IDao.class);
		BoardDto boardDto = iDao.contentViewDao(board_num);
		
		model.addAttribute("boardDto", boardDto);
		
		return "contentView";
	}
	
	@RequestMapping(value = "/content_modify")
	public String content_modify(HttpServletRequest request, Model model) {
		String board_num = request.getParameter("board_num");
		
		IDao iDao = sqlSession.getMapper(IDao.class);
		BoardDto boardDto = iDao.contentViewDao(board_num);
		
		model.addAttribute("boardDto", boardDto);
		
		return "contentModify";
	}
	
	@RequestMapping(value = "/modifyOk")
	public String modifyOk(HttpServletRequest request, Model model) {
		String board_num = request.getParameter("board_num");
		String board_title = request.getParameter("board_title");
		String board_content = request.getParameter("board_content");
		String board_name = request.getParameter("board_name");
		
		BoardDto boardDto = new BoardDto();
		boardDto.setBoard_num(Integer.parseInt(board_num));
		boardDto.setBoard_title(board_title);
		boardDto.setBoard_content(board_content);
		boardDto.setBoard_name(board_name);
		
		IDao iDao = sqlSession.getMapper(IDao.class);
		iDao.boardUpdateDao(boardDto);
		
		return "redirect:content_view?board_num=" + board_num;
	}
	
}
