package ch10_02_throws;

public class ThrowTest {

	public static void main(String[] args) {
		// 인위적으로 에러를 발생시키는 방법

		int age = -1;
		if(age < 0) {
			throw new IllegalArgumentException("나이는 음수를 사용하실 수 없습니다.");
		}
		
		try {
			throw new ArithmeticException("모든 수는 0으로 나눌 수 없습니다.");
		} catch (Exception e) {
			
		}
		System.out.println("저는 12번 라인입니다");
	}

}
