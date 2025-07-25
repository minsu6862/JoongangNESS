package inheritanceTest;

public class Solider extends Person {
	int armyNum;
	
	public void printInfo() {
		System.out.println("이름은 " + name + ", 나이는 " + age + ", 군번은 " + armyNum);
	}
}
