package com.minsu.test;

public class Calculator {

	public void add(int a, int b) { //더하기
		System.out.println("덧셈 : a + b = " + (a+b));
	}
	
	public void sub(int a, int b) { //빼기
		System.out.println("뺄셈 : a - b = " + (a-b));
	}
	
	public void mult(int a, int b) { //곱하기
		System.out.println("곱셈 : a * b = " + (a*b));
	}
	
	public void divi(int a, int b) { //나누기
		System.out.println("나눗셈 : a / b = " + (a/b));
	}
}
