package exceptionTest;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		// 1번
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 숫자 입력 : ");
		double num1 = sc.nextInt();
		System.out.print("두번째 숫자 입력 : ");
		double num2 = sc.nextInt();
		
		try {
			double sum = num1 / num2;
			System.out.println("입력한 값의 나눈값은 " + sum);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("0으로는 나눌수 없습니다.");
		}
		
		
		//2번
		System.out.print("문자열을 입력해 주세요 : ");
		sc.nextLine();
		String str1 = sc.nextLine();
		
		try {
			if (str1.trim().isEmpty()) {  // 공백 제거 
                throw new IllegalArgumentException("반드시 문자열을 입력해야합니다.");
            }
            System.out.println("입력한 문자열의 길이는 " + str1.length() + "입니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		//3번
		System.out.print("정수값 숫자 입력 : ");
		
		try {
			int num3 = sc.nextInt();
			if ((num3 % 2) == 1) {
				System.out.println("홀수입니다");
			} else {
				System.out.println("짝수입니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("정수값인 숫자를 입력하셔야 합니다.");
		}
		
		
		//4번
		try {
			ThrowsExample.readFile();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("제대로 된 파일을 선택해 주세요");
		}
		
		sc.close();
	}

}
