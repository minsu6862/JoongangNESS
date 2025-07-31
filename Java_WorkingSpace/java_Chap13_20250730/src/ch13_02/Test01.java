package ch13_02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BoardDao dao = new BoardDao();
		List<Board> list = dao.getBoardDao();
		
		
		Iterator<Board>iterator = list.iterator();
		while(iterator.hasNext()) {
			Board board = iterator.next();
			System.out.println(board.getTitle() + " - " + board.getContent());
		}
	}

}

class Board {
	private String title, content;

	public Board() {}

	public Board(String title, String content) {
		this.title = title;
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}

class BoardDao {
	public List getBoardDao() {
		List<Board> list = new ArrayList<Board>();
		list.add(new Board("제목1", "내용1"));
		list.add(new Board("제목2", "내용2"));
		list.add(new Board("제목3", "내용3"));
		
		return list;
	}
}