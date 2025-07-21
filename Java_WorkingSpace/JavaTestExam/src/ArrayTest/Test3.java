package ArrayTest;

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 3, 7, 3, 3, 5, 3, 6, 9, 3, 3, 3};
		
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 3) {
				count++;
			}
		}
		System.out.println(count);
	}

}
