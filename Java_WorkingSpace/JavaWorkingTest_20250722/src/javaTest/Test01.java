package javaTest;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a = 0;	//홀수
		int b = 0;	//짝수
		
		for(int i = 1; i <= 100; i++) {
			if(i % 2 == 1) {
				a++;
			} else {
				b++;
			}
		}
		System.out.println("홀수 개수 : " + a);
		System.out.println("짝수 개수 : " + b);
	}

}
