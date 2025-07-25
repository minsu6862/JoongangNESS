package ch08_01_test;

import ch08_01.Shape;

public class Television implements RemoteControl {

	@Override
	public void turnOn() {
		System.out.println("TV ON");
	}

	@Override
	public void turnOff() {
		System.out.println("TV OFF");
	}

}
