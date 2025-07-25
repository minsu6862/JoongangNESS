package ch08_01;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//			Shape shape = new Shape(); 인터페이스는 객체 생성 불가
		Shape shape = new Rectangle();	//업캐스팅
		shape = new Triangle();	//업캐스팅
		shape.getArea();
		shape.getColor();
		
		Draw draw = new Triangle();
		draw.drawPen();
		draw.drawShape();
		
		Triangle tr1 = new Triangle();
		tr1.drawPen();
		tr1.getArea();
	}

}
