package stringClassTest;

public class Main {

	public static void main(String[] args) {
		// 1번
		String str1 = "abcabcabc";
		int startIndex = 0;
		int foundIndex;
		int sum = 0;
		
		while((foundIndex = str1.indexOf("ab", startIndex)) != -1) {
			sum++;
			startIndex = foundIndex + 1;
			
		}
		System.out.println("ab 의 개수 : " + sum);
		
		
		//2번
		try {
			String str2 = "korea@korea.com";
			String Id = str2.substring(0, str2.indexOf("@"));
			String domain = str2.substring(str2.indexOf("@") + 1, str2.length());
			System.out.print("아이디 : " + Id + ", ");
			System.out.println("도메인 : " + domain);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("부정확한 이메일 입니다.");
		}
		
		
		//3번 "banana" 에서 중복된 문자를 제거하면 "ban" 이 됩니다. 중복으로 나오는 문자를 제거하여 "banana"를 "ban"으로 출력하는 프로그램을 작성하시오.
		String str3 = "banana";
		String result = "";
		for (int i = 0; i < str3.length(); i++) {
			if (result.indexOf(str3.charAt(i))  == -1 ) {
				result += str3.charAt(i);
			}
		}
		System.out.println(result);
		
		
		//4번
		String str4 = "i like chopin";
		String result2 = "";
		result2 += str4.toUpperCase().charAt(0);
		for(int i = 1; i < str4.length(); i++) {
			if(str4.charAt(i-1) == ' ') {
		        result2 += str4.toUpperCase().charAt(i);
		    } else {
		        result2 += str4.charAt(i);
		    }
		}
		System.out.println(result2);
		
		
		//5번
		String str5 = "Hello123, Java456";
		int count = 0;
		for(int i = 0; i < str5.length(); i++) {
			char c = str5.charAt(i);
		    if((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
		        count++;
		    }
		}
		System.out.println(count);
	}

}
