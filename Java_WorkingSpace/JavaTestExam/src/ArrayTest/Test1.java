package ArrayTest;

public class Test1 {
	public static void main(String[] args) {
		
		int[] arr = {90, 80, 70, 100, 85};
		
		int sum = 0;
		int avg = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		
		avg = sum / arr.length;
		System.out.println(avg);
	}
}
