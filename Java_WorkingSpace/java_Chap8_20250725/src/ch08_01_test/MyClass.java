package ch08_01_test;

public class MyClass {
	
	RemoteControl rc = new Television();	//인터페이스 필드선언 가능
	
	public MyClass(RemoteControl rc) {
		this.rc = rc;
	}
	
	public void methosA() {	//인터페이스 로컬변수 선언 가능
		RemoteControl rc = new Audio();
	}
	
	public void methodB(RemoteControl rc) {	//인터페이스 매개변수 인자값으로도 가능
		
	}
}
