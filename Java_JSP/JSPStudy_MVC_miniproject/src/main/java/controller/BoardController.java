package controller;

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

import command.*;
import dao.BoardDao;
import dao.MemberDao;
import dto.BoardDto;
import dto.BoardMemberDto;
import dto.MemberDto;

@WebServlet("*.do")
public class BoardController extends HttpServlet {
	private static final int PAGE_GROUP_SIZE = 10;
	
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
		MemberDao memberDao = new MemberDao();
		List<BoardDto> bDtos = new ArrayList<BoardDto>();
		List<BoardMemberDto> bmDtos = new ArrayList<BoardMemberDto>();
		HttpSession session = null;
		BCommand bCommand = null;
		
		if(comm.equals("/list.do")) {
			String searchType = request.getParameter("searchType");
			String searchKeyword = request.getParameter("searchKeyword");
			
			//페이징
			int page = 1;
			if(request.getParameter("page") != null) {
				//유저가 보고싶어하는 페이지의 번호
				page = Integer.parseInt(request.getParameter("page"));
			}
			
			int totalBoardCount = 0;  // 전체 게시글 수를 저장할 변수
			
			// 검색 여부에 따라 데이터 가져오기
			if(searchType != null && searchKeyword != null && !searchKeyword.strip().isEmpty()) {
		        // 검색 기능 구현
				bDtos = boardDao.searchBoardList(searchType, searchKeyword, page);
				totalBoardCount = boardDao.countSearchBoard(searchType, searchKeyword);  // 검색 결과 총 개수
				
				request.setAttribute("searchType", searchType);
		        request.setAttribute("searchKeyword", searchKeyword);
		        
		        if(totalBoardCount == 0) {
		            request.setAttribute("noSearchResult", true);
		            request.setAttribute("searchMessage", "'" + searchKeyword + "'에 대한 검색 결과가 없습니다.");
		        }
		    } else {
		        // 전체 목록
		        bDtos = boardDao.boardList(page);
		        totalBoardCount = boardDao.countBoard();
		    }
			
			// 페이징 계산
			int totalPage = (int) Math.ceil(((double)totalBoardCount / BoardDao.PAGE_SIZE));
			
			int startPage = (((page - 1) / PAGE_GROUP_SIZE) * PAGE_GROUP_SIZE) + 1;
			int endPage = startPage + PAGE_GROUP_SIZE - 1;
			
			// endPage가 totalPage를 초과하지 않도록 조정
			if(endPage > totalPage) {
				endPage = totalPage;
			}
			
			// 검색 결과가 없을 때는 현재 페이지를 1로 설정
			if(totalBoardCount == 0 && page > 1) {
			    page = 1;
			}
			
			// 데이터를 JSP로 전달
			request.setAttribute("bDtos", bDtos);		// JSP에서 사용하는 변수명과 일치
			request.setAttribute("currentPage", page);	//유저가 선택한 현재 페이지 번호
			request.setAttribute("totalPage", totalPage);	//전체 글 개수로 계산한 전체 페이지수
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			
			viewPage = "boardList.jsp";
			/*
			 * RequestDispatcher dispatcher = request.getRequestDispatcher("boardList.jsp");
			 * dispatcher.forward(request, response);
			 */
		} else if (comm.equals("/write.do")) {
			session = request.getSession();
			String sid = (String) session.getAttribute("sessionId");
			if(sid != null) {	//로그인 상태라면
				viewPage = "writeForm.jsp";
			} else {
				response.sendRedirect("login.do?msg=2");
				return;
			}
			
			viewPage = "writeForm.jsp";
		} else if (comm.equals("/writeOk.do")) {
			request.setCharacterEncoding("UTF-8");
			
			bCommand = new BWriteCommand();
			bCommand.excute(request, response);
			
			
			// Command 실행 결과에 따라 리다이렉트 처리
		    String writeResult = (String) request.getAttribute("writeResult");
		    
		    if("success".equals(writeResult)) {
		        // 성공 시 목록으로 리다이렉트
		        response.sendRedirect("list.do");
		        return;
		    } else {
		        // 실패 시 작성 폼으로 리다이렉트  
		        response.sendRedirect("write.do");
		        return;
		    }
		} else if (comm.equals("/modify.do")) {
			/*
			 * session = request.getSession(); String sid =
			 * (String)session.getAttribute("sessionId");
			 */
			
			String bnum = request.getParameter("bnum");
			BoardDto bDto = boardDao.ContentView(bnum);
			
			//수정 삭제를 controller에서 관리할 경우, 일반적으론 modify페이지에서 jdbc로 설정 가능(작성자 != 세션아이디 인 경우 수정삭제 아예 안보이게)
			/* if(bDto.getMemberid().equals(sid)) { //참이면 수정, 삭제 가능
			 * request.setAttribute("boardDto", bDto); viewPage = "modifyForm.jsp"; } else {
			 * response.sendRedirect("modifyForm.jsp?error=1"); return; }
			 */ 
			
			if(bDto == null) {	//유저가 선택했을때, 작성자가 삭제하거나 게시판매니저가 삭제한 경우
				viewPage = "deletePage.jsp";
			} else {
				request.setAttribute("bDto", bDto);
				viewPage = "modifyForm.jsp";
			}
		} else if (comm.equals("/modifyOk.do")) {
			request.setCharacterEncoding("UTF-8");
			
			// Command 패턴으로 처리
		    bCommand = new BModifyCommand();
		    bCommand.excute(request, response);
		    
		    // Command 실행 결과에 따라 리다이렉트 처리
		    String modifyResult = (String) request.getAttribute("modifyResult");
		    String bnum = (String) request.getAttribute("bnum");
		    
		    if("success".equals(modifyResult)) {
		        // 성공 시 해당 게시글 상세보기로 리다이렉트
		        response.sendRedirect("content.do?bnum=" + bnum);
		        return;
		    } else {
		        // 실패 시 수정 폼으로 리다이렉트 (또는 에러 페이지)
		        if(bnum != null && !bnum.trim().isEmpty()) {
		            response.sendRedirect("modify.do?bnum=" + bnum);
		        } else {
		            response.sendRedirect("list.do");
		        }
		        return;
		    }
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
		} else if(comm.equals("/login.do")) {
			viewPage = "login.jsp";
		} else if(comm.equals("/loginOk.do")) {
			request.setCharacterEncoding("UTF-8");
			String loginId = request.getParameter("id");
			String loginPw = request.getParameter("pw");
			
			int loginFlag = memberDao.loginCheck(loginId, loginPw);
			
			if(loginFlag == 1) {
				session = request.getSession();
				session.setAttribute("sessionId", loginId);
				
				response.sendRedirect("list.do");
		        return;
			} else {
				response.sendRedirect("login.do?msg=1");
				return;
			}
		} else if(comm.equals("/signUp.do")) {
			viewPage = "signUp.jsp";
		} else if(comm.equals("/signUpOk.do")) {
			request.setCharacterEncoding("UTF-8");
			String loginId = request.getParameter("id");
			String loginPw = request.getParameter("pw");
			String loginPwChek = request.getParameter("pwCheck");
			String loginName = request.getParameter("name");
			String loginEmail = request.getParameter("email");
			
			if(!loginPw.equals(loginPwChek)) {
				response.sendRedirect("signUp.do?msg=1");
			    return;
			} else {
				int result = memberDao.signUpChek(loginId);
				if(result == 1) {
					response.sendRedirect("signUp.do?msg=2");
				    return;
				} else if (result == 0) {
					memberDao.signUpMember(loginId, loginPw, loginName, loginEmail);
					System.out.println(loginId + "님 회원가입 성공");
					response.sendRedirect("login.do");
				    return;
				} else {
					response.sendRedirect("signUp.do?msg=3");
				    return;
				}
			}
		} else if(comm.equals("/logout.do")) {
			session = request.getSession(false);
		    
		    // 이전 페이지 URL 가져오기
		    String referer = request.getHeader("Referer");
		    
		    if(session != null) {
		        String logoutUserId = (String) session.getAttribute("sessionId");
		        session.invalidate(); // 세션 무효화
		        System.out.println(logoutUserId + "님 로그아웃 완료");
		    }
		    
		    // 이전 페이지가 있으면 그곳으로, 없으면 메인으로
		    if(referer != null && !referer.isEmpty() && 
		       !referer.contains("login.do") && !referer.contains("logout.do")) {
		        response.sendRedirect(referer);
		    } else {
		        response.sendRedirect("index.jsp");
		    }
		    return;
		} else if(comm.equals("/main.do")) {
			viewPage = "index.jsp";
		} else if(comm.equals("/myPage.do")) {
			// 로그인 상태 확인
		    session = request.getSession();
		    String sessionId = (String) session.getAttribute("sessionId");
		    
		    if(sessionId == null) {	// 로그인하지 않은 상태라면 로그인 페이지로
		        response.sendRedirect("login.do?msg=2");
		        return;
		    }
		    
		    // URL 파라미터로 받은 memberId와 세션의 sessionId 비교
		    String memberId = request.getParameter("memberId");
		    if(memberId == null) {
		        memberId = sessionId;
		    }
		    
		    // 본인 확인
		    if(!sessionId.equals(memberId)) {
		        response.sendRedirect("list.do");
		        return;
		    }
		    
			MemberDto memberDto = memberDao.MyPageView(memberId);
			
			if(memberDto == null) {
				// 데이터를 못 가져온 경우 이전 페이지로 돌아가기
		        String referer = request.getHeader("Referer");
		        if(referer != null && !referer.isEmpty() && 
		           !referer.contains("myPage.do")) {
		            response.sendRedirect(referer);
		        } else {
		            response.sendRedirect("list.do");  // 기본값
		        }
		        return;
			} else {
				request.setAttribute("memberDto", memberDto);
				viewPage = "myPage.jsp";
			}
		} else if(comm.equals("/updateMember.do")) {
			request.setCharacterEncoding("UTF-8");
			
			// 로그인 상태 확인
		    session = request.getSession();
		    String sessionId = (String) session.getAttribute("sessionId");
		    
		    if(sessionId == null) {
		        response.sendRedirect("login.do?msg=2");
		        return;
		    }
			
			String memberId = request.getParameter("memberId");
			String memberPw = request.getParameter("memberPw");
			String memberName = request.getParameter("memberName");
			String memberEmail = request.getParameter("memberEmail");
			
			// 입력값 검증
		    if (memberId == null || memberId.trim().isEmpty() || 
		        memberPw == null || memberPw.trim().isEmpty() || 
		        memberName == null || memberName.trim().isEmpty() || 
		        memberEmail == null || memberEmail.trim().isEmpty()) {
		        
		        System.out.println("입력값이 비어있음 - 수정 실패");
		        response.sendRedirect("myPage.do?memberId=" + memberId + "&msg=3");
		        return;
		    }
		    
		    // 비밀번호 확인
		    int loginFlag = memberDao.loginCheck(memberId, memberPw);

		    if (loginFlag == 1) {	// 비밀번호가 맞으면 회원정보 수정 실행
		        int updateResult = memberDao.memberUpdate(memberId, memberPw, memberName, memberEmail);
		        
		        if(updateResult > 0) {
		            System.out.println(memberId + "님 회원정보 수정 완료");
		            response.sendRedirect("myPage.do?msg=1");
		        } else {
		            System.out.println(memberId + "님 회원정보 수정 실패 - DB 업데이트 오류");
		            response.sendRedirect("myPage.do?msg=2");
		        }
		        return;
		        
		    } else {
		        // 비밀번호가 틀렸을 때
		        System.out.println("비밀번호 틀림 - 수정 실패");
		        response.sendRedirect("myPage.do?msg=4");
		        return;
		    }
			
		} else {
			viewPage = "index.jsp";
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		//boardList.jsp에게 웹 서블릿 내에서 제작한 request객체를 전달해라
		dispatcher.forward(request, response);
	}
}
