package ch10_02_trycatch;

public class MulthTryCatchTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			int a = 10 / 0;
			
			int[] arr = { 1, 2, 3 };
			System.out.println(arr[3]);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("17번라인입니다.");
	}

}
