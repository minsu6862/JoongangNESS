package ch08_02_03_cast;

public class Bus implements Vehicle {

	@Override
	public void run() {	//인터페이스한테 받은 추상메소드 오버라이딩
		// TODO Auto-generated method stub
		System.out.println("버스가 달립니다.");
	}

	public void checkFare() {	//버스 클래스 고유 메소드
		System.out.println("승차입니다.");
	}
}
