package ch05_01;

public class StringTest02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str1 = "kor";
		String str2 = "kor";
		
		if(str1 == str2) {
			System.out.println("문자열 같음");
		} else {
			System.out.println("문자열 다름");
		}
		
		if(str1.equals(str2) ) {
			System.out.println("문자열 같음");
		} else {
			System.out.println("문자열 다름");
		}
	}

}
