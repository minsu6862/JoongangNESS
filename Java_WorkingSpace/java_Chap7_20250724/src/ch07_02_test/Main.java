package ch07_02_test;

public class Main {

	public static void main(String[] args) {
		
		//-------------------------업캐스팅---------------------------
		Animal animal = new Dog();
		animal.name = "바둑이";
//		animal.age = 4; 자식 클래스의 필드 접근은 불가능
		animal.sound();	//필드는 접근이 안되지만 메소드는 메소드영역에 따로 있기 때문에 오버라이딩된 메소드는 실행 가능
		
		
		//-------------------------다운캐스팅----------------------------
		Dog dog;
		dog = (Dog) animal;	//다운캐스팅을 하려는 animal은 실제 인스턴스가 dog객체기 때문에 가능함
		dog.age = 10;
		dog.name = "백구";
		dog.sound();
		
		
		//-------------------------캐스팅 오류------------------------------
		Animal animal2 = new Animal();
		/*
		Dog dog2 = (Dog) animal2; //실제 인스턴스가 부모클래스인 animal이기 때문에 다운캐스팅시 오류남
		따라서 instanceOf를 사용해 형변환 하는것이 안정적임
		*/
		Dog dog2;
		if (animal2 instanceof Dog) {
			dog2 = (Dog) animal2;	//조건이 안맞아서 실행되지 않음
		}
		
		
		
		Animal animal3 = new Cat();
		// animal3.eat(); 자식메소드 접근 불가능, 오버라이딩이 된 메소드가 아니기 때문에
		Cat cat = (Cat) animal3;
		cat.eat(); //자식 메소드 접근 가능
		
		Dog dog3;
		if(animal instanceof Dog) {
			dog3 = (Dog) animal;
			dog3.sound();
		}
	}

}
