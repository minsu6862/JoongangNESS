package ch13_03;

import java.util.Stack;

//문자열 뒤집기 : Hello 문자열을 거꾸로 출력하시오
public class StackQuiz01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str= "Hello";
		
		Stack<Character> stack1 = new Stack<Character>();
		
		for(int i = 0; i < str.length(); i++) {
			char str2 = str.charAt(i);
			stack1.push(str2);
		}
		
		while(!stack1.isEmpty()) {
			System.out.print(stack1.pop());
		}
	}

}
