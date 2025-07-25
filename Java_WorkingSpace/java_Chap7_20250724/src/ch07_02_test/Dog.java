package ch07_02_test;

public class Dog extends Animal {
	int age;
	
	@Override
	public void sound() {
		System.out.println("멍멍");
	}
}
