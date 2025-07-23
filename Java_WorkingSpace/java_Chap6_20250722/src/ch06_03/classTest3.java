package ch06_03;

public class classTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Engine engine = new Engine("가솔린", 500);
		
		Car car = new Car("소나타", 200, engine);
		
		car.carEngineType();
	}
}

class Car {
	String name;
	int maxSpeed;
	Engine engine;

	public Car(String name, int maxSpeed, Engine engine) {
		this.name = name;
		this.maxSpeed = maxSpeed;
		this.engine = engine;
	}
	
	public void carEngineType() {
		System.out.println("엔진 타입 : " + engine.type);
		engine.printEngine();
	}
}

class Engine {
	String type;
	int power;

	public Engine() {
		
	};

	public Engine(String type, int power) {
		this.type = type;
		this.power = power;
	}
	
	public void printEngine() {
		System.out.println("엔진 타입은 " + type);
	}
	
	public String[] outputCars() {
		String[] cars = {"소나타", "아반떼", "K5" };
		return cars;
	}
}