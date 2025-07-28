package ch10_02_trycatch;

public class TryCatchTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num = 0;
		
		try {
			int result = 100 / num;
		} catch (ArithmeticException e) {
			System.out.println("모든 수는 0으로 나눌 수 없습니다");
		}
		
		
	}

}
