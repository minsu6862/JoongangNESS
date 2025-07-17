package chap02_01;

public class TestClass3 {
	public static void main(String[] args) {
		char var1 = 'A';
		char var2 = 'B';
		char var3 = '가';
		char var4 = 'a';		//""로 쓰지 않는 이유는 java에서 ""는 문자열 ''는 문자로 구별해 인식하기 때문
		char var5 = 65; 
		
		System.out.println(var1);
		System.out.println(var5);
		
		String ch4 = "너무 졸리다";
		
		System.out.println(ch4);
		
		String str1 = ("오늘은 비가 많이 옵니다. \n내일은 맑으면 좋겠습니다." );
		System.out.println(str1);
		
		boolean fact = true;
		boolean fake = false;
		
		System.out.println("진실은 " + fact + ", 거짓은 " + fake + "입니다.");
		
	}
}
