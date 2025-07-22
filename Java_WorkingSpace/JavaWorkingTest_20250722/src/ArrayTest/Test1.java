package ArrayTest;

public class Test1 {
	public static void main(String[] args) {
		
		int[] arr = {90, 80, 70, 100, 85};
		
		int sum = 0;
		double avg = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		
		avg = (double) sum / arr.length;		//정확한 값을 위한 실수로 값을 출력하기 위해 강제 형변환
		System.out.println(avg);
	}
}
