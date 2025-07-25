package ch08_01_test;

import ch08_01.Shape;

public class Audio implements RemoteControl {

	@Override
	public void turnOn() {
		System.out.println("Audio ON");
	}

	@Override
	public void turnOff() {
		System.out.println("Audio OFF");
	}

}
