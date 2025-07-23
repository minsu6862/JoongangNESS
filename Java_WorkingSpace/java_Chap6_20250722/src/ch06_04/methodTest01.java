package ch06_04;

public class methodTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Calculator cal1 = new Calculator();
		int sum1 = cal1.add(10, 20);
		System.out.println(sum1);
		
		int sum2 = cal1.minus(10, 20);
		System.out.println(sum2);
		
		int sum3 = cal1.multiply(10, 20);
		System.out.println(sum3);
		
		double sum4 = cal1.divide(10, 20);
		System.out.println(sum4);
		
		int sum5 = cal1.total(new int[] {10, 20, 30});
		System.out.println(sum5);
	}
}

class Calculator {
	
	public int add(int num1, int num2) {
		return num1 + num2;
	}
	
	public int minus(int num1, int num2) {
		return num1 - num2;
	}
	
	public int multiply(int num1, int num2) {
		return num1 * num2;
	}
	
	public double divide(int num1, int num2) {
		return (double)num1 / num2;
	}
	
	public int total(int[] nums) {
		int total = 0;
		for(int num : nums) {
			total += num;
		}
		return total;
	}
}