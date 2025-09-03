package com.minsu.miniproject.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.minsu.miniproject.dao.BoardDao;
import com.minsu.miniproject.dto.BoardDto;

@Controller
public class BoardController {

	static final int PAGE_SIZE = 10;	//한페이지당 표시할 게시글 수
	static final int BLOCK_SIZE = 5;	//페이지 블럭에 표시될 페이지의 수
	
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping(value = "/list")
	public String list(HttpServletRequest request, Model model) {
		
		int pageNum = 1; //유저가 클릭한 페이지 번호, 초기값은 무조건 1로 설정
		
		if(request.getParameter("pageNum") != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));//유저가 선택한 페이지 번호
		}
		
		int startRow = (PAGE_SIZE * pageNum) - 9;
		int endRow = PAGE_SIZE * pageNum;
		
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		List<BoardDto> boardDtos = boardDao.pageBoardList(startRow, endRow);
		
		int totalCount = boardDao.allBoardCount();
		
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
		
		model.addAttribute("boardCount", boardDao.allBoardCount()); 
		
		return "board/list";
	}
	
	@RequestMapping(value = "/write")
	public String write(HttpSession session, Model model) {
		String sessionId = (String) session.getAttribute("sessionId");
		if(sessionId == null) { //로그인하지 않은 상태
			model.addAttribute("msg", "로그인한 회원만 글쓰기가 가능합니다.");
			model.addAttribute("url", "login");
			
			return "alert/alert";
		}
		model.addAttribute("sessionId", sessionId);
		
		return "board/write";
	}
	
	@RequestMapping(value = "/writeOk")
	public String writeOk(HttpServletRequest request, Model model) {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");
		
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		boardDao.boardWrite(title, content, writer);
		
		return "redirect:list";
	}
	
	@RequestMapping(value = "/contentView")
	public String contentView(HttpServletRequest request, Model model) {
		
		String bnum = request.getParameter("bnum"); //유저가 클릭한 글의 번호
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		
		boardDao.updateHit(bnum); //조회수 증가함수 호출
		//메서드 호출 순서 주의
		BoardDto boardDto = boardDao.contentView(bnum);
		
		model.addAttribute("boardDto", boardDto);
		
		return "board/content";
	}
	
	@RequestMapping(value = "/modify")
	public String modify(HttpServletRequest request, HttpSession session, Model model) {
		String boardNum = request.getParameter("bnum"); //유저가 클릭한 글의 번호
		String sessionId = (String) session.getAttribute("sessionId");
		
		// 로그인 체크 추가
	    if(sessionId == null) {
	        model.addAttribute("msg", "로그인이 필요합니다.");
	        model.addAttribute("url", "login");
	        return "alert/alert";
	    }
		
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		
		//메서드 호출 순서 주의
		BoardDto boardDto = boardDao.contentView(boardNum);
		
		if(sessionId.equals(boardDto.getBwriter())) {
			model.addAttribute("boardDto", boardDto);
			
			return "board/modify";
		} else {
			model.addAttribute("msg", "작성자가 아니면 삭제할 수 없습니다");
			model.addAttribute("url", "contentView?bnum=" + boardNum);
			
			return "alert/alert";
		}
	}
	
	@RequestMapping(value = "/modifyOk")
	public String modifyOk(HttpServletRequest request, HttpSession session, Model model) {
		String bnum = request.getParameter("bnum");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		String sessionId = (String) session.getAttribute("sessionId");
		
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		int result = boardDao.boardModify(bnum, btitle, bcontent);
		
		if(result == 1) { //수정 성공->1, 실패->0
			model.addAttribute("msg", "글 수정이 성공 하였습니다.");
			model.addAttribute("url", "list");			
		} else {
			model.addAttribute("msg", "글 수정이 실패 하였습니다.");
			model.addAttribute("url", "list");	
		}
		return "alert/alert";
	}
	
	@RequestMapping(value = "/delete")
	public String delete(HttpServletRequest request, HttpSession session, Model model) {
		String boardNum = request.getParameter("bnum");
		String boardWriter = request.getParameter("bwriter");
		String sessionId = (String) session.getAttribute("sessionId");
		//디버깅용
		System.out.println(boardWriter);
		System.out.println(sessionId);
		
		// 로그인 체크 추가
	    if(sessionId == null) {
	        model.addAttribute("msg", "로그인이 필요합니다.");
	        model.addAttribute("url", "login");
	        return "alert/alert";
	    }
		
		if(!sessionId.equals(boardWriter)) {
			model.addAttribute("msg", "작성자가 아니면 삭제할 수 없습니다");
			model.addAttribute("url", "contentView?bnum=" + boardNum);
			
			return "alert/alert";
		} else {
			BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
	        int result = boardDao.boardDelete(boardNum);
	        
	        if(result == 1) { // 삭제 성공
	            model.addAttribute("msg", "글이 삭제되었습니다.");
	            model.addAttribute("url", "list");
	        } else { // 삭제 실패
	            model.addAttribute("msg", "글 삭제에 실패했습니다.");
	            model.addAttribute("url", "contentView?bnum=" + boardNum);
	        }
	        
	        return "alert/alert";
		}
		
	}
	
	
	
}
