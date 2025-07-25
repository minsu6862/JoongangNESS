package ch07_03;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Rectangle rect = new Rectangle(10, 20);
		System.out.println("사각형의 넓이 : " + rect.getArea());
		
		Circle circle = new Circle();
		circle.setRadius(10);
		System.out.println("원의 넓이 : " + circle.getArea());
		
		Shape tri = new Triangle(10, 20);
		System.out.println("삼각형의 넓이 : " + tri.getArea());
		
		Triangle tri2;
		tri2 = (Triangle) tri;
		System.out.println("삼각형의 넓이 : " + tri2.getArea());
	}

}
