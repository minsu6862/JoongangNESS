package ch07_03;

public class Circle extends Shape {
	static final double PI = 3.14;
	double radius;
	
	@Override
	public double getArea() {
		return PI * radius * radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public void getColor() {
		System.out.println("원 색깔" + color);
	}
	
}
