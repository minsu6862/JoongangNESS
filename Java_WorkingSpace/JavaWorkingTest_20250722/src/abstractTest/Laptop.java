package abstractTest;

public class Laptop extends Computer {

	@Override
	public void turnOn() {
		System.out.println("노트북 켜짐");
	}

	@Override
	public void turnOff() {
		System.out.println("노트북 꺼짐");
	}

}
