package ch07_02;

public class TireMain {

	public static void main(String[] args) {
		Tire tire;
		
		//자식 필드인 tireCompanyKH 사용 불가
		tire = new KumhoTire();
		
		//에러남 실제객체오류, 업캐스팅 후 다운캐스팅을 하면 가능
//		Tire tire2 = new Tire();
//		HankukTire hankuk;
//		hankuk = (HankukTire) tire2;
		
		KumhoTire kumho;
		kumho = (KumhoTire) tire;
		
		//자식 형태일땐 부모 메소드 사용 가능
		kumho.tireName = "스노우 타이어";
	}

}
