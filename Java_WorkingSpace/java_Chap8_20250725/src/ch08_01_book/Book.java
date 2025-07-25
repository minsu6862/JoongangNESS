package ch08_01_book;

public class Book {	//책 1권의 정보를 저장할 객체 -> DTO class, VO class
	private String title, author;
	private int id;
	
	public Book() {
	}

	public Book(String title, String author, int id) {
		this.title = title;
		this.author = author;
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String bookInfo() {
		String bookInfo = "[" + id + "]" + title + " by " + author; 
		return bookInfo;
	}
}
