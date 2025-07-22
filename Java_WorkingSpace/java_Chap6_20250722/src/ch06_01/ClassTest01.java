package ch06_01;

public class ClassTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Person people = new Person("홍길동", 123);
		people.active();
	}

}

class Person {
	String name;
	int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void active() {
		System.out.println("제 이름은 " + name + ", 나이는 " + age + "입니다.");
	}
}