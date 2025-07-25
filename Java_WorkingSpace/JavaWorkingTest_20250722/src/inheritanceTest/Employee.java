package inheritanceTest;

public class Employee extends Person {
	String CompanyName;
	
	public void printInfo() {
		System.out.println("이름은 " + name + ", 나이는 " + age + ", 회사이름은 " + CompanyName);
	}
}
