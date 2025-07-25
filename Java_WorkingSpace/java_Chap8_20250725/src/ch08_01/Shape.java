package ch08_01;

public interface Shape {
	//인터페이스 내에서는 상수만 선언 가능
	public static final double SALE_RATE = 0.2;
	
	public void getArea(); // 추상메소드 선언 가능, 인터페이스에서는 abstact를 생략해서 써도 됌
	public void getColor();
}
