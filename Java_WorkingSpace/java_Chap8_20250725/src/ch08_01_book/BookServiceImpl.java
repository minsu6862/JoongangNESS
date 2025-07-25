package ch08_01_book;

import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements BookService {

	private List<Book> books = new ArrayList<Book>();
	
	@Override
	public void addBook(Book book) {
		books.add(book);	//북 객체를 비어있는 리스트에 순서대로 넣어주는 메소드
	}

	@Override
	public Book findBookByTitle(String title) {
		for (Book bookTemp : books) {
			if(bookTemp.getTitle().equals(title));
			return bookTemp;	//일치하는 책을 찾을 경우 책 정보 반환
		}
		return null;	//일치하는 책을 못찾을 경우 null반환
	}

	@Override
	public List<Book> getAllBooks() {
		return books;
	}

}
