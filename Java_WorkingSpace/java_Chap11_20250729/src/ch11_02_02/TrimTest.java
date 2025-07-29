package ch11_02_02;

import java.util.Scanner;

public class TrimTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("좋아하는 위인을 입력하세요 : ");
		String str = sc.nextLine();
		
		System.out.println(str.trim());	//문장 양 옆 스페이스바 공백만 제거
		System.out.println(str.length());
		
		System.out.println(str.strip());	//문장 양 옆 스페이스바와 특수문자같은경우의 공백도 제거(trim 상위호환)
		System.out.println(str.length());
	}

}
