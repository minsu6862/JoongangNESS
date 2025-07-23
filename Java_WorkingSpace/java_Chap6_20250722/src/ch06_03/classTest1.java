package ch06_03;

public class classTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle c = new Circle(5);
		c.CircleArea();
	}

}

class Circle {
	int radius;
	double PI = 3.14;
	
	public Circle() {
		
	}

	public Circle(int radius) {
		this.radius = radius;
	}
	
	public void CircleArea() {
		double sum = radius * radius * PI;
		System.out.println("원의 넓이는 " + String.format("%.2f", sum));
	}
}