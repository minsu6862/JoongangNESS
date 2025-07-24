package ch06_06;

import ch06_06_1.AutoCar;

public class Car {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AutoCar autoCar = new AutoCar();
		Tire tire = new Tire();
		
		tire.tireName = "금호";
		tire.tirePrice = 100000;
		
		tire.tirePrint();
	}

}
