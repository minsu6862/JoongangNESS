package command;

import dao.BoardDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BWriteCommand implements BCommand {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		BoardDao boardDao = new BoardDao();
		
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
            
            // 성공 시 결과를 request에 설정
            request.setAttribute("writeResult", "success");
            
        } else {
            // 입력값이 비어있을 때 실패 결과 설정
            System.out.println("입력값이 비어있음 - 작성 폼으로 돌아감");
            request.setAttribute("writeResult", "fail");
        }
	}
	
}
