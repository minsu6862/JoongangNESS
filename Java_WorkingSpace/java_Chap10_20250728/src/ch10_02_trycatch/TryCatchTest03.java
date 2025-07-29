package ch10_02_trycatch;

import java.util.Scanner;

public class TryCatchTest03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("문자열을 입력하세요");
		String str = sc.nextLine();	//	문자열을 키보드로부터 입력 받음
		
		if(str.length() == 0) {
			throw new IllegalArgumentException("문자열을 공백으로 설정할 수 없습니다.");
		} else {
			System.out.println(str.length());	// 문자열 길이 출력
		}
		
	}

}
