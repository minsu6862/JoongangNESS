package ch07_02;

public class Car {
	String carName;
	int maxSpeed, year, price;
	
//	Tire frontTire = new KumhoTire();
//	Tire backTire = new HankukTire();
	
	Tire frontTire;
	Tire backTire;
	
	//매개변수에 인수로 금호타이어 객체가 들어오면 금호, 한국타이어 객체가 들어오면 한국 이렇게 출력하는 메소드
	public void tirePrint(Tire tire) {
		tire.tireName();
	}
}
