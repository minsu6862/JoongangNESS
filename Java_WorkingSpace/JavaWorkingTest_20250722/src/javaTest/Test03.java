package javaTest;

public class Test03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Car car = new Car("기아" , 1998);
		car.carYear();
	}

}


class Car {
	String brand;
	int year;
	
	public Car() {
	}

	public Car(String brand, int year) {
		this.brand = brand;
		this.year = year;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public void carYear() {
		System.out.println("해당 자동차의 연식은 " + (2025 - year));
	}
}