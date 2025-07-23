package ClassTest;

public class AverageCalculator {
	int[] a;

	public AverageCalculator(int[] a) {
		this.a = a;
	}
	
	public void getAverage() {
		int sum = 0;
		for(int num : a) {
			sum += num;
		}
		System.out.println(sum/a.length);
	}
}
