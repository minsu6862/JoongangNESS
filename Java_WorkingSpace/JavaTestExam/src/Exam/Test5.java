package Exam;

public class Test5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a = 50;	//약수의 개수를 구할 숫자
		
		for(int i = 1; i <= a; i++) {
			if(a % i == 0) {
				System.out.print(i + ", ");
			}
		}
	}
}
