package ch06_05;

public class SingletonTest {		//메모리에 하나만 존재하여야 하는 인스턴트를 만드는 클래스
	private static SingletonTest singleton = new SingletonTest();
	
	private SingletonTest() {
		
	}
	
	public static SingletonTest getInstance() {
		return singleton;
	}
}
