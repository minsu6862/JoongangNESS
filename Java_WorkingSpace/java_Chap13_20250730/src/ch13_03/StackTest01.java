package ch13_03;

import java.util.Stack;

public class StackTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<String> stack1 = new Stack<String>();
		
		stack1.push("1) Kor");
		stack1.push("2) Jpn");
		stack1.push("3) Usa");
		
		while(!stack1.isEmpty()) {
			String str = stack1.pop();
			System.out.println(str);
		}
	}

}
