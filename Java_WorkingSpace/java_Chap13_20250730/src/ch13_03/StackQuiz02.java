package ch13_03;

import java.util.HashMap;
import java.util.Map;

//괄호가 올바르게 되어있는지 검사	
public class StackQuiz02 {

	public static void main(String[] args) {
		String str= "(())(()";
		
		Map<Character, Integer> check = new HashMap<Character, Integer>();
		for(int i = 0; i < str.length(); i++) {
			char str2 = str.charAt(i);
			check.put(str2, check.getOrDefault(str2, 0) + 1);
		}
		
		int result = check.get('(') - check.get(')');
		if (result == 0) {
			System.out.println("괄호가 올바르게 있습니다.");
		} else {
			System.out.println("괄호가 틀립니다.");
		}
		
	}

}
