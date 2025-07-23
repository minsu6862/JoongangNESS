package ch06_03;

public class classTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Calculator c = new Calculator(5, 4);
		c.Calc();
	}
}

class Calculator {
	int a, b;

	public Calculator(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	public void Calc() {
		System.out.println("덧셈 : " + (a + b));
		System.out.println("뺄셈 : " + (a - b));
		System.out.println("곱셈 : " + (a * b));
		System.out.println("나눗셈 : " + ((double) a / b));
	}
}