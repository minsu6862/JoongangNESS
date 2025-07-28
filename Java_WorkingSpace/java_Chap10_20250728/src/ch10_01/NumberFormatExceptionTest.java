package ch10_01;

public class NumberFormatExceptionTest {

	public static void main(String[] args) {
		// 숫자로 바꿀 수 없는 문자열을 숫자로 바꾸려고 할 때 발생하는 에러
		String str = "1,000원";
		int num = Integer.parseInt(str);
		
	}

}
