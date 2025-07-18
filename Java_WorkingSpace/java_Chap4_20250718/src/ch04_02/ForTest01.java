package ch04_02;

public class ForTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 5; i++) {
			System.out.println("안녕하세요 " + (i + 1) + "번째 채팅 입력입니다.");
		}
		
		for (int i = 0; i < 10; i++) {
			if (i % 2 == 1) {
				System.out.println("1부터 10 사이의 홀수 :" + i);
			}
		}
		
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			sum += i;
		}
		System.out.println("총 합은 : " + sum);
		
		
	}
}
