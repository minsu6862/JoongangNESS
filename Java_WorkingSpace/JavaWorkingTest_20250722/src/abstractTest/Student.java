package abstractTest;

public class Student extends Person {

	Student(String name) {
		super(name);
	}

	@Override
	void sayHello() {
		System.out.println("안녕하세요, 저는 학생입니다.");
	}

}
