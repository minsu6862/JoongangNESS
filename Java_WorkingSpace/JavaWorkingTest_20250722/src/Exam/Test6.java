package Exam;

public class Test6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int sum = 0;
		
		for(int i = 1; i <= 100; i++) {
			sum += i;
			if(sum >= 100) {
				System.out.println("100이상이 되기 직전의 수의 합 : " + sum + ", 마지막 더한 수는 : " + i + "입니다.");
				break;
			}
		}
	}
}
