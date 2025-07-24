package ch06_05;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SingletonTest single1 = SingletonTest.getInstance();
		SingletonTest single2 = SingletonTest.getInstance();
		SingletonTest single3 = SingletonTest.getInstance();
		
		if (single1 == single2) {
			System.out.println("같은 객체를 대조중");
		} else {
			System.out.println("다른 객체를 대조중");
		}
		
		final int scr = 400;
	}

} 
