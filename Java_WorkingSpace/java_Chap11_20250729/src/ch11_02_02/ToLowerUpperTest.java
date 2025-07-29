package ch11_02_02;

public class ToLowerUpperTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str1 = "KOREA";
		String str2 = "japan";
		String str3 = "JAPAN";
		
		System.out.println(str1.toLowerCase());	//모두 소문자로 변경, 원본 수정 x
		System.out.println(str2.toUpperCase());	//모두 대문자로 변경, 원본 수정 x
		
		if(str2.equals(str3)) {	//대소문자 구별하고 비교
			System.out.println("두 문자가 같습니다");
		} else {
			System.out.println("두 문자가 다릅니다");
		}
		
		if(str2.equalsIgnoreCase(str3)) {	//대소문자 구별 안하고 비교
			System.out.println("두 문자가 같습니다");
		} else {
			System.out.println("두 문자가 다릅니다");
		}
	}

}
