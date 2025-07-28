package ch10_01;

public class ClassCastExceptionTest {

	public static void main(String[] args) {
		Object oj = new String("Korea");
		Integer a = (Integer) oj;
		// 다운캐스팅 메모리 참조 오류
	}

}
