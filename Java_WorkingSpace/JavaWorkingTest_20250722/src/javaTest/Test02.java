package javaTest;

public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Helloworld!!, Hello JAVA!!";
		int count = 0;
		
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
		    if((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
		        count++;
		    }
		}
		
		System.out.println("알파벳의 개수 : " + count);
	}

}
