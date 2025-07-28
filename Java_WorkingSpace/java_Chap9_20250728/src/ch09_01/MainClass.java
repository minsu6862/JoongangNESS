package ch09_01;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a = new A();
		
		A.B b = a.new B();
		b.field1 = 10;
		b.method1();
		
		A.C c = new A.C();
		c.field1 = 100;
		c.method1();
		A.C.field2 = 50;
		A.C.method2();
		
		a.methodLocal();
		
		System.out.println("======================");
		
		Button btn = new Button();
		
		btn.setListner(new CallListner());
		btn.touch();
	}

}
