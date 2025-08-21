package board;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/boardlist")	//boardlist요청만 구현
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//게시판 하단에 표시될 현재 글의 갯수로 만들어진 전체 페이지 수
	private static final int PAGE_GROUP_SIZE = 10;
    BoardDao boardDao = new BoardDao();
    
    public BoardController() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//게시판 페이지 번호 없이 접근한 경우 무조건 초기값 1(1페이지) 내용 보여주기
		int page = 1;
		
		int totalBoardCount = boardDao.countBoard();
		
		if(request.getParameter("page") != null) {
			//유저가 보고싶어하는 페이지의 번호
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		List<BoardDto> boardDtos = boardDao.boardList(page);
		int totalPage = (int) Math.ceil(((double)totalBoardCount / BoardDao.PAGE_SIZE));
		
		int startPage = (((page - 1) / PAGE_GROUP_SIZE) * PAGE_GROUP_SIZE) + 1;
		int endPage = startPage + PAGE_GROUP_SIZE - 1;
		request.setAttribute("boardDtos", boardDtos);	//유저가 선택한 페이지에 해당하는 글들(10개)
		request.setAttribute("currentPage", page);	//유저가 선택한 현재 페이지 번호
		request.setAttribute("totalPage", totalPage);	//전체 글 개수로 계산한 전체 페이지수
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("boardList.jsp");		
		dispatcher.forward(request, response);	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
