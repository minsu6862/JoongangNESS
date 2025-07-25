package ch08_01_book;

import java.util.List;

public interface BookService {
	
	public void addBook(Book book);
	public Book findBookByTitle(String title);	//책 제목을 입력하면 해당 책 정보를 검색해 반환하는 메소드
	public List<Book> getAllBooks();	//모든 책 정보를 묶은 책정보 목록 반환 메소드
}
