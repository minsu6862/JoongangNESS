package ClassTest;

public class Book {
	String name;
	int price;
	
	public Book(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public void printInfo() {
		System.out.println("책의 이름 : " + name + ", 가격 : " + price);
	}
}
