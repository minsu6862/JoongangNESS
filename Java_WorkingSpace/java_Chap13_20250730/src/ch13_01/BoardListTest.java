package ch13_01;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BoardListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Board> boardList = new ArrayList<Board>();
		Date nowDate = new Date();
		
		Board board1 = new Board();
		board1.setWriter("홍길동");
		board1.setTitle("안녕하세요!");
		board1.setContent("가입인사 드립니다. 반갑습니다");
		board1.setDate(new Timestamp(nowDate.getTime()));
		
		boardList.add(board1);
		boardList.add(new Board("이순신", "저는 이순신입니다.", "저는 조선의 해군입니다", new Timestamp(nowDate.getTime())));
		Board board2 = new Board("김유신", "저는 김유신입니다.", "저는 신라의 장군입니다", new Timestamp(nowDate.getTime()));
		
		boardList.add(board2);
		
		for(int i = 0; i < boardList.size(); i++) {
			Board index = boardList.get(i);
			System.out.println(index.getTitle() + " | " + index.getContent() + " | " + index.getWriter() + " | " + index.getDate());
		}
	}

}
