package ch11_01;

public class ClassTest {

	public static void main(String[] args) {
		Class cla = Car.class;

		System.out.println(cla.getName());
		System.out.println(cla.getSimpleName());
		System.out.println(cla.getPackage());
	}

}
