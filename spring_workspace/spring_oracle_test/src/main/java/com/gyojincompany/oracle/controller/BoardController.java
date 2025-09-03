package com.gyojincompany.oracle.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gyojincompany.oracle.dao.BoardDao;
import com.gyojincompany.oracle.dto.BoardDto;

@Controller
public class BoardController {
	
	static final int PAGE_SIZE = 10;	//한페이지당 표시할 게시글 수
	static final int BLOCK_SIZE = 5;	//페이지 블럭에 표시될 페이지의 수
	
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping(value = "/bwrite")
	public String bwrite(HttpSession session, Model model) { //글쓰기 양식(폼) 페이지를 띄우는 요청
		
		String sid = (String) session.getAttribute("sessionId");
		if(sid == null) { //로그인하지 않은 상태
			model.addAttribute("msg", "로그인한 회원만 글쓰기가 가능합니다.");
			model.addAttribute("url", "login");
			
			return "alert/alert";
		}
		
		return "write_form";
	}
	
	@RequestMapping(value = "/bwriteOk")
	public String bwriteOk(HttpServletRequest request, Model model) { //글쓰기 양식(폼)에서 유저가 쓴 글 데이터를 가져다가 DB에 넣는 요청
		
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		String bwriter = request.getParameter("bwriter");
		
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		boardDao.boardWriteDao(btitle, bcontent, bwriter); //글쓰기		
		
		return "redirect:blist";
	}
	
	@RequestMapping(value = "/blist")
	public String blist(Model model) {
		
		//System.out.println("blist->boardList");
		
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		List<BoardDto> boardDtos = boardDao.boardListDao(); //모든 글 가져오기(조인 테이블)
		model.addAttribute("boardList", boardDtos);
		
		model.addAttribute("boardCount", boardDao.AllBoardCountDao()); //모든 글 갯수 전달하기
		
		return "boardList";
	}
	
	@RequestMapping(value = "/blist2")
	public String blist2(Model model) {
		
		//System.out.println("blist->boardList");
		
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		List<BoardDto> boardDtos = boardDao.boardListDao(); //모든 글 가져오기(조인 테이블)
		model.addAttribute("boardList", boardDtos);
		
		model.addAttribute("boardCount", boardDao.AllBoardCountDao()); //모든 글 갯수 전달하기
		
		return "boardList2";
	}
	
	@RequestMapping(value = "/boarddelete")
	public String boarddelete(HttpServletRequest request, Model model) {
		
		String bnum = request.getParameter("bnum"); //삭제할 글의 번호
		
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		int result = boardDao.boardDeleteDao(bnum); //삭제 성공->1, 실패->0
		
		if (result == 0) { //삭제 실패
			model.addAttribute("msg", "글 삭제가 실패 하였습니다. 다시 확인해 주세요.");
			model.addAttribute("url", "blist");
		} else {
			model.addAttribute("msg", "글 삭제가 성공 하였습니다.");
			model.addAttribute("url", "blist");
		}
		
		return "alert/alert";
	}
	
	@RequestMapping(value = "/contentview")
	public String contentview(HttpServletRequest request, Model model) {
		
		String bnum = request.getParameter("bnum"); //유저가 클릭한 글의 번호
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		
		boardDao.updateHitDao(bnum); //조회수 증가함수 호출
		//메서드 호출 순서 주의
		BoardDto boardDto = boardDao.contentViewDao(bnum);
		
		model.addAttribute("boardDto", boardDto);
		
		return "boardContent";
	}

	@RequestMapping(value = "/boardmodify")
	public String boardmodify(HttpServletRequest request, Model model) {
		
		String bnum = request.getParameter("bnum");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		int result = boardDao.boardModifyDao(bnum, btitle, bcontent);
		
		if(result == 1) { //수정 성공->1, 실패->0
			model.addAttribute("msg", "글 수정이 성공 하였습니다.");
			model.addAttribute("url", "blist");			
		} else {
			model.addAttribute("msg", "글 수정이 실패 하였습니다.");
			model.addAttribute("url", "blist");			
		}
		return "alert/alert";
	}
	
	@RequestMapping(value = "/pagelist")
	public String blist(HttpServletRequest request, Model model) {
		
		int pageNum = 1; //유저가 클릭한 페이지 번호, 초기값은 무조건 1로 설정
		
		if(request.getParameter("pageNum") != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));//유저가 선택한 페이지 번호
		}
		
		int startRow = (PAGE_SIZE * pageNum) - 9;
		int endRow = PAGE_SIZE * pageNum;
		
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		List<BoardDto> boardDtos = boardDao.pageBoardListDao(startRow, endRow); //모든 글 가져오기(조인 테이블)
		int totalCount = boardDao.AllBoardCountDao();
		
		int startPage = (((pageNum - 1) / BLOCK_SIZE) * BLOCK_SIZE) + 1;
		int endPage = startPage + BLOCK_SIZE - 1;
		int totalPage = (int) Math.ceil((double) totalCount / PAGE_SIZE);
		
		if(endPage > totalPage) {
			endPage = totalPage;
		}
		
		model.addAttribute("boardList", boardDtos);
		model.addAttribute("pageNum", pageNum);	//유저가 클릭한 페이지 번호 -> 현재 페이지
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("totalPage", totalPage);
		
		model.addAttribute("boardCount", boardDao.AllBoardCountDao()); //모든 글 갯수 전달하기
		
		return "pagelist";
	}
	
	@RequestMapping(value = "/test")
	public String test() {
		
		return "test";
	}
	
	@RequestMapping(value = "/kakaomap")
	public String kakaomap() {
		
		return "mapTest";
	}
	
	
}