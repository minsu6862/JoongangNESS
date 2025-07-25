package inheritanceTest;

public class Trucks extends Car {
	int price;
	
	public void carInfo (String name, String size) {
		System.out.println("차명은 " + name + ", 크기는 " + size + ", 가격은 " + price);
	}
}
