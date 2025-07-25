package ch07_02;

public class HankukTire extends Tire {		//자식

	String tireCompanyHK;
	
	@Override
	public void tireName() {
		System.out.println("한국 타이어");
	}
}
