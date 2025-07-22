package ClassExam;

public class Product {
	String name;
	int price;
	int quantity;
	
	public Product(int price, int quantity) {
		this.price = price;
		this.quantity = quantity;
	}
	
	public int getTotalPrice() {
		return price * quantity;
	}
}
