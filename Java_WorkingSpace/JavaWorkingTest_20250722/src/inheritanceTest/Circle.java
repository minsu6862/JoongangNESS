package inheritanceTest;

public class Circle extends Shape {
	static final double PI = 3.14;
	
    public double shapeArea(double width, double height) {
        double radius = width * 0.5;
        sum = PI * radius * radius;
        return sum;
    }
}
