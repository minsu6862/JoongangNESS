package chap03_02;

public class OperatorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a = 0;
		int b = 10;
		a++;
		b--;
		
		System.out.println(a);
		System.out.println(b);
		
		int x = 1;
		int y = 1;
		int z = 2;
		
		int result1 = x++ + ++z +10;
		int result2 = ++y + z++ + 10;
		
		System.out.println(result1);
		System.out.println(result2);
		
		System.out.println(17 / 3);
		System.out.println(17 % 3);
		
		int kor = 80;
		int eng = 85;
		int mat = 70;
		int sci = 50;
		
		if (kor >= 90 || eng >=90 || mat >= 90 ) {
			System.out.println("우수");
		}
		
		if (kor <= 90 || eng <= 90 || mat <= 90 || sci <= 90 ) {
			System.out.println("과락");
		}
	}
}
