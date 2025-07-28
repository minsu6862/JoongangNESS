package ch10_02_throws;

public class ThrowsSample {
	//메소드를 호출하는 쪽에서 예외처리를 강제하는 구문인 throws
	public void ZeroDivid() throws Exception {
//		try {
//			System.out.println(10 / 0);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("0나누기 에러");
//		}
		System.out.println(10 / 0);
	}
}
