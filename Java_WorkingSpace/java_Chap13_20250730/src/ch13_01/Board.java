package ch13_01;

import java.sql.Timestamp;

//DTO(Data Transfor Object
public class Board {

	private String writer;	//글쓴이
	private String title;
	private String content;
	private Timestamp date;
	
	public Board() {
		
	}
	
	public Board(String writer, String title, String content, Timestamp date) {
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.date = date;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
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

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}
	

}
