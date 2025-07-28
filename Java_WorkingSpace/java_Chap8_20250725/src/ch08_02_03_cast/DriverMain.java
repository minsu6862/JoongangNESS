package ch08_02_03_cast;

public class DriverMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Driver driver = new Driver();
		
		Bus bus = new Bus();
		Truck truck = new Truck();
		
		driver.carDriver(bus);
		driver.carDriver(truck);
	}

}
