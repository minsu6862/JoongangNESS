package inheritanceTest;

public class Circle extends Shape {
	static final double PI = 3.14;
	
	public double shapeArea(double radius) {
		sum = PI * radius * radius;
		return sum;
	}
}
