package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.BoardDao;
import dto.BoardDto;

@WebServlet("*.do")
public class BoardController extends HttpServlet {
	
    public BoardController() {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String comm =uri.substring(conPath.length());
		System.out.println("comm : " + comm);
		
		String viewPage = null;
		
		BoardDao boardDao = new BoardDao();
		List<BoardDto> bDtos = new ArrayList<BoardDto>();
		
		if(comm.equals("/list.do")) {
			bDtos = boardDao.boardList();
			request.setAttribute("bDtos", bDtos);
			viewPage = "boardList.jsp";
		} else if (comm.equals("/write.do")) {
			viewPage = "writeForm.jsp";
		} else if (comm.equals("/modify.do")) {
			viewPage = "modifyForm.jsp";
		} else if (comm.equals("/delete.do")) {
			String bnum = request.getParameter("bnum");
		    System.out.println("삭제 요청된 bnum: " + bnum); // 디버깅용
		    
		    if(bnum != null && !bnum.trim().isEmpty()) {
		        boardDao.boardDelete(bnum);
		        System.out.println("게시글 " + bnum + "번 삭제 완료");
		        
		        // 삭제 후 목록으로 리다이렉트
		        response.sendRedirect("deletePage.jsp?type=deleted");
		        return; // forward 대신 redirect 사용
		    } else {
		        // bnum이 없으면 목록으로
		    	response.sendRedirect("list.do");
		        viewPage = "list.do";
		    }
		} else if (comm.equals("/content.do")) {
			String bnum = request.getParameter("bnum");
			
			BoardDto bDto = boardDao.ContentView(bnum);
			
			if(bDto == null) {	//유저가 선택했을때, 작성자가 삭제하거나 게시판매니저가 삭제한 경우
				viewPage = "deletePage.jsp";
			} else {
				request.setAttribute("bDto", bDto);
				viewPage = "contentView.jsp";
			}
		} else if (comm.equals("/writeOk.do")) {
			request.setCharacterEncoding("UTF-8");
			
			String memberid = request.getParameter("author");
			String btitle = request.getParameter("title");
			String bcontent = request.getParameter("content");
			
			// 입력값 검증
		    if(btitle != null && !btitle.trim().isEmpty() && 
		       bcontent != null && !bcontent.trim().isEmpty() && 
		       memberid != null && !memberid.trim().isEmpty()) {
		        
		        // 게시글 작성
		        boardDao.boardWrite(btitle, bcontent, memberid);
		        System.out.println("새 게시글 작성 완료: " + btitle);
		        
		        // PRG 패턴: 작성 완료 후 목록으로 리다이렉트
		        response.sendRedirect("list.do");
		        return;
		        
		    } else {
		        // 입력값이 비어있으면 다시 작성 폼으로
		        System.out.println("입력값이 비어있음 - 작성 폼으로 돌아감");
		        response.sendRedirect("write.do");
		        return;
		    }
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		//boardList.jsp에게 웹 서블릿 내에서 제작한 request객체를 전달해라
		dispatcher.forward(request, response);
	}
}
