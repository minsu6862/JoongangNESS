package ch09_02;

public class MainClass {
	
	public static void operate(Calculator cal) {	//	임시 객체가 인수값으로 들어옴
		System.out.println("연산 결과 : " + cal.add(10, 20));
	}

	public static void main(String[] args) {
		Greeting greeting = new Greeting() {

			@Override
			public void sayHi() {
				System.out.println("안녕! 하이!");
			}
		};
		
		greeting.sayHi();
		
		System.out.println("=====================");
		Animal animal = new Animal() {

			@Override
			void sound() {
				System.out.println("멍멍");
			}

			@Override
			void run() {
				System.out.println("깡총깡총");
			}
		};
		
		animal.sound();
		animal.run();
		
		System.out.println("=====================");
		
		//메서드에 매개변수로 익명 객체 전달\
		operate(new Calculator() {
			
			@Override
			public int add(int a, int b) {
				return a + b;
			}
		});	//	calculator로 만든 객체만 인수로 넣을 수 있음 -> 인터페이스는 객체생성 불가 -> 익명객체 생성
	}

}
