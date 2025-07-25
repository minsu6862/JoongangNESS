package inheritanceTest;

public class Student extends Person {
	int grade;
	
	public void printInfo() {
		System.out.println("이름은 " + name + ", 나이는 " + age + ", 학번은 " + grade);
	}
}
