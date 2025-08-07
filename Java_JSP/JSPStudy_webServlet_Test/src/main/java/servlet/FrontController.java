package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dto.BoardDto;
import dto.memberDto;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request->mid, mpw
		request.setCharacterEncoding("utf-8");
		
		//StringBuffer url = request.getRequestURL();
		String uri = request.getRequestURI(); //클라이언트가 요청한 URI
		//System.out.println(uri); // /jsp_webServlet-20250807/loginOk.do
		String con = request.getContextPath(); //컨텍스트 패스 가져오기
		//System.out.println(con); // /jsp_webServlet-20250807
		//uri - con = loginOk.do
		String command = uri.substring(con.length()); //컨텍스트 패스의 길이 인덱스 부터 끝까지 추출
		System.out.println("클라이언트 요청 : " + command); // /loginOk.do
		
		String viewPage = ""; //실제 클라이언트에게 전송될 jsp파일의 이름이 저장될 변수
		HttpSession session = null;
		
		if(command.equals("/loginOk.do")) {
			String mid = request.getParameter("mid");
			String mpw = request.getParameter("mpw");
			
			if(mid.equals("tiger") && mpw.equals("12345")) { //참이면 로그인 성공
				session = request.getSession(); //세션을 선언(생성)				
				session.setAttribute("sid", mid); //세션에 id값 올리기->로그인 상태로 변경
				// response.sendRedirect("welcom.jsp"); 
				request.setAttribute("mid", mid);
				viewPage = "welcome.jsp";
			} else { //로그인 실패
				System.out.println("로그인 실패!!");
				
				request.setAttribute("errorMsg", "아이디 또는 비밀번호가 잘못되었습니다. 다시 확인하세요.");
				viewPage = "login.jsp";
			}
		} else if(command.equals("/login.do")) { //login.jsp로 이동
			viewPage = "login.jsp";
		} else if(command.equals("/welcome.do")) { //login.jsp로 이동
			viewPage = "welcome.jsp";
		} else if(command.equals("/logout.do")) {
			session = request.getSession();
			session.invalidate();
			request.setAttribute("errorMsg", "로그아웃 하신 후 다시 로그인 하시려면 아이디와 비밀번호를 재입력하십시오.");
			viewPage = "login.jsp";
		} else if(command.equals("/freeboard.do")) {
			List<BoardDto> boardList = new ArrayList<BoardDto>();
			
			boardList.add(new BoardDto("오늘 날씨가 덥습니다", "이순신", "2025-08-01"));
			boardList.add(new BoardDto("목요일입니다.", "김유신", "2025-08-02"));
			boardList.add(new BoardDto("고려의 장군입니다", "강감찬", "2025-08-03"));
			boardList.add(new BoardDto("벌써 8월입니다.", "홍길동", "2025-08-04"));
			boardList.add(new BoardDto("사료아저씨입니다", "개종민", "2025-08-05"));
			
			request.setAttribute("boardList", boardList);	//리퀘스트객체에 게시판 목록 싣기
			
			viewPage = "boardList.jsp";
		} else if(command.equals("/member.do")) {
			//private String mnum, mid, mname, mage, mdate;
			List<memberDto> memList = new ArrayList<memberDto>();
			
			memList.add(new memberDto("1","tiger" , "홍길동","17" , "2025-03-01"));
			memList.add(new memberDto("2","lion" , "김유신","19" , "2025-04-09"));
			memList.add(new memberDto("3","blackCat" , "이순신","21" , "2025-04-11"));
			memList.add(new memberDto("4","whitedog" , "강감찬","27" , "2025-05-05"));
			memList.add(new memberDto("5","redtiger" , "이몽룡","31" , "2025-06-20"));
			
			request.setAttribute("memList", memList);	//리퀘스트객체에 게시판 목록 싣기
			
			viewPage = "memList.jsp";
		}
		
		//response.sendRedirect(viewPage); -> 이동시킬때 request 객체 포함 안됨
		
		//viewPage에 저장된 jsp 페이지로 이동시킬때 request 객체를 포함해서 이동 시키는 방법
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
		
		
	}

}
