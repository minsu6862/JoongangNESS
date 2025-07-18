package ch04_01;

public class SwitchTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = (int) (Math.random() * 6) + 1;
	
		switch (x) {
		case  1  :
			System.out.println("주사위 값은 1 입니다.");
			break;
		case 2  :
			System.out.println("주사위 값은 2입니다.");
			break;
		case 3  :
			System.out.println("주사위 값은 3 입니다.");
			break;
		case 4  :
			System.out.println("주사위 값은 4 입니다.");
			break;
		case 5  :
			System.out.println("주사위 값은 5 입니다.");
			break;
		case 6  :
			System.out.println("주사위 값은 6 입니다.");
			break;
		default :
			System.out.println("Error");
			break;
		}
	}
}
