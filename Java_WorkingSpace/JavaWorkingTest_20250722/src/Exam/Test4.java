package Exam;

public class Test4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a = 0;	//짝수
		int b = 0;	//홀수
		
		for(int i = 1; i <= 100; i++) {
			if (i % 2 == 0) {	//짝수개수 합
				a++;
			} else {	//홀수개수 합
				b++;
			}
		}
		
		System.out.println("짝수의 개수 : " + a + ", 홀수의 개수 : " + b);
	}

}
