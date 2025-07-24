package ch07_01;

public class Animal {
	String name, sound;
	int age, legCount;
	
	public void eat() {
		System.out.println("음식을 먹는다");
	}
	
	public void howling() {
		System.out.println("울음 소리 : " + sound);
	}
}
