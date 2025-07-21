package ArrayTest;

public class Test4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10, 20, 30, 40, 50};
		
		for(int i = 0; i < arr.length; i++) {
			if((i + 1) % 2 == 1) {
				System.out.print(arr[i] + ", ");
			}
		}
	}

}
