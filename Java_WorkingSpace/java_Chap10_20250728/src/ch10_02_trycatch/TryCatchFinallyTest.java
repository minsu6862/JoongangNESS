package ch10_02_trycatch;

public class TryCatchFinallyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 10, 20, 30 };
		
		try {
			for(int i = 0; i <= 3; i++) {
				System.out.println(arr[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("에러가 발생했습니다.");
		} finally {
			System.out.println("저는 에러가 나든 안나든 무조건 실행입니다");
		}
	}

}
