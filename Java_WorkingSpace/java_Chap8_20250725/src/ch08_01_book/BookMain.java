package ch08_01_book;

import java.util.Scanner;

public class BookMain {

	public static void main(String[] args) {
		
		BookService bookServ1 = new BookServiceImpl();
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("");
			System.out.println("===도서관리 시스템===");
			System.out.println("1. 도서 추가");
			System.out.println("2. 도서 목록 조회");
			System.out.println("3. 도서 검색");
			System.out.println("4. 프로그램 종료");
			System.out.println("=================");
			System.out.print("메뉴 선택 : ");
			int num = scanner.nextInt();	//사용자가 입력한 정수 번호 저장
			
			switch (num) {
			case 1: {
				System.out.print("도서 ID : ");
				int bookId = scanner.nextInt();
				scanner.nextLine();
				System.out.print("도서 제목 : ");
				String bookTitle = scanner.nextLine();		//문자열 입력
				System.out.print("도서 저자 : ");
				String bookAuthor = scanner.nextLine();
				
				Book book = new Book(bookTitle, bookAuthor, bookId);
				bookServ1.addBook(book);
				System.out.println("입력하신 도서가 저장되었습니다");
				break;
			}
			case 2: {
				System.out.println("****** 도서 목록 ******");
				for(Book bookTemp : bookServ1.getAllBooks()) {
					System.out.println(bookTemp.getTitle() + " / " + bookTemp.getAuthor());
				}
				break;
			}
			case 3: {
	
			}
			case 4: {
				System.out.println("도서 관리 프로그램을 종료합니다.");
				scanner.close();
				break;
			}
			default:
				System.out.println("잘못된 정보 선택입니다.");
			}
		}
	}

}
