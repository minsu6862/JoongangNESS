package ch11_02_02;

public class CharAtTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Korea";
		
		for(int i = 0; i < str.length(); i++) {
			System.out.println(str.charAt(i));
			if(str.charAt(i) == 'o') {
				System.out.println("문자열에 o가 포함되어있습니다");
			}
		}
		
	}

}
