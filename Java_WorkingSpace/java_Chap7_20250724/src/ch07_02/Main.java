package ch07_02;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double a;
		int b= 10;
		a = b;
		
		String c = "100";
		int d = Integer.parseInt(c);
		
		Person person = new Person();
		Student student = new Student();
		Soldier soldier = new Soldier();
		
		person = student;	//업캐스팅, 자식클래스를 부모클래스로 참조타입을 바꾸는것
		student = (Student) person;	//다운캐스팅, 부모클래스를 자식클래스로 참조타입을 바꾸는것
		//soldier = student; 그냥 이건 불가능함
		
		
		
		
		Car myCar = new Car();
		myCar.carName = "소나타";
		myCar.year = 2010;
		myCar.frontTire = new KumhoTire();
		myCar.backTire = new HankukTire();
		
		KumhoTire tr1 = new KumhoTire();
		HankukTire tr2 = new HankukTire();
		
		myCar.tirePrint(tr1);
		myCar.tirePrint(tr2);
	}

}
	