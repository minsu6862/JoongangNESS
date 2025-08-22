package command;

import dao.BoardDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BModifyCommand implements BCommand {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		BoardDao boardDao = new BoardDao();
        
        String bnum = request.getParameter("bnum");
        String btitle = request.getParameter("title");
        String bcontent = request.getParameter("content");
        
        // 입력값 검증
        if(bnum != null && !bnum.trim().isEmpty() && 
           btitle != null && !btitle.trim().isEmpty() && 
           bcontent != null && !bcontent.trim().isEmpty()) {
            
            // 게시글 수정
            boardDao.boardUpdate(bnum, btitle, bcontent);
            System.out.println("게시글 " + bnum + "번 수정 완료: " + btitle);
            
            // 성공 시 결과를 request에 설정
            request.setAttribute("modifyResult", "success");
            request.setAttribute("bnum", bnum); // 리다이렉트용 bnum 저장
            
        } else {
            // 입력값이 비어있을 때 실패 결과 설정
            System.out.println("입력값이 비어있음 - 수정 실패");
            request.setAttribute("modifyResult", "fail");
            request.setAttribute("bnum", bnum); // 실패해도 bnum은 유지
        }
	}

}
