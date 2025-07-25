package abstractTest;

public class Desktop extends Computer {
	@Override
	public void turnOn() {
		System.out.println("데스크탑 켜짐");
	}

	@Override
	public void turnOff() {
		System.out.println("데스크탑 꺼짐");
	}

}
