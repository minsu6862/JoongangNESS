package ch11_02_02;

public class JuminNumTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String jumin = "990725-3234567";
		
		char gender = jumin.charAt(7);
		switch (gender) {
		case '1', '3': {
			System.out.println("남자입니다.");
			break;
			}
		case '2', '4': {
			System.out.println("여자입니다.");
			break;
			}
		}
	}

}
