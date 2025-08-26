package com.minsu.test;

public class MyCalc {

	private int a; //첫번째 인수
	private int b; //두번째 인수
	//Calculator calculator = new Calculator(); //객체를 멤버변수로 선언 -> calculator 객체에게 의존하는 관계 성립
	Calculator calculator;
	
	public MyCalc() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MyCalc(Calculator calculator) {
		super();
		this.calculator = calculator;
	}
	
	public MyCalc(int a, int b, Calculator calculator) {
		super();
		this.a = a;
		this.b = b;
		this.calculator = calculator;
	}

	public void addition() {
		calculator.add(this.a, this.b);
	}
	
	public void subtraction() {
		calculator.sub(this.a, this.b);
	}
	
	public void multiplication() {
		calculator.mult(this.a, this.b);
	}
	
	public void divsion() {
		calculator.divi(this.a, this.b);
	}
	
	//calculator setter 선언
	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}

	public void setA(int a) {
		this.a = a;
	}

	public void setB(int b) {
		this.b = b;
	}
	
}
