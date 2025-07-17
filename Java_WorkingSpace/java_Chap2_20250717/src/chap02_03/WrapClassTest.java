package chap02_03;

public class WrapClassTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "100000";
		int money = Integer.parseInt(str);
		double money2 = Double.parseDouble(str);
		System.out.println(money);
		System.out.println(money2);
		
		int score = 77;
		String str2 = String.valueOf(score);
		String str3 = Integer.toString(score);
		
		System.out.println(str2 + ", " + str3);
		System.out.printf("money의 값은 : %d, money2의 값은 : %.1f", money, money2);
	}

}
