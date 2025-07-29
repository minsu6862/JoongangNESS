package ch11_01;

public class SystemTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for(int i = 0; i < 10000; i++) {
			System.out.println(i);
			if (i == 5000) {
				break;
//				System.exit(i);
			}
		}
		System.out.println("for문 종료 후 출력되는 문장");
		
		long time1 = System.nanoTime();
		long mTime1 = System.currentTimeMillis();
		System.out.println("==========================");
		
		long sum = 0L;
		for(int i = 0; i <= 10000000; i++) {
			sum += i;
		}
		System.out.println(sum);
		System.out.println("==========================");
		long time2 = System.nanoTime();
		long mTime2 = System.currentTimeMillis();
		
		System.out.println(time2 - time1);
		//1초를 10억으로 나눈 초
		System.out.println(mTime2 - mTime1);
		//1초를 1000으로 나눈 초
	}

}
