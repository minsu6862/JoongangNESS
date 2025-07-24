package ch06_06;

import java.sql.Timestamp;

public class Board {
	private String writter, title, content;
	private  Timestamp date;
	
	public Board() {
	}

	public Board(String writter, String title, String content, Timestamp date) {
		this.writter = writter;
		this.title = title;
		this.content = content;
		this.date = date;
	}

	public String getWritter() {
		return writter;
	}

	public void setWritter(String writter) {
		this.writter = writter;
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
