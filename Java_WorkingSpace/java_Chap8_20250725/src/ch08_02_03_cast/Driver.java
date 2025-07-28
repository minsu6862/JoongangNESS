package ch08_02_03_cast;

public class Driver {
	public void carDriver(Vehicle vehicle) {
		if(vehicle instanceof Bus ) {
			Bus bus = (Bus) vehicle;	//매개변수로 입력된 인수값이 bus로 만든 객체인지 확인 후 대입
			bus.checkFare();
		}
		vehicle.run();
	}
}
