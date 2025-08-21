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
    BoardDao boardDao = new BoardDao();
    
    public BoardController() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//게시판 페이지 번호 없이 접근한 경우 무조건 초기값 1(1페이지) 내용 보여주기
		int page = 1;
		
		if(request.getParameter("page") != null) {
			//유저가 보고싶어하는 페이지의 번호
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		List<BoardDto> boardDtos = boardDao.boardList(page);
		
		request.setAttribute("boardDtos", boardDtos);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("boardList.jsp");		
		dispatcher.forward(request, response);	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
