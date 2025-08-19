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
		} else if (comm.equals("/mofidy.do")) {
			viewPage = "modifyForm.jsp";
		} else if (comm.equals("/delete.do")) {
			viewPage = "boardList.do";
		} else if (comm.equals("/content.do")) {
			viewPage = "contentView.do";
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		//boardList.jsp에게 웹 서블릿 내에서 제작한 request객체를 전달해라
		dispatcher.forward(request, response);
	}
}
