package ch05_01;

import java.util.Arrays;

public class StringTest03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numArr1 = null;
		int[] numArr2 = {1, 2, 3, 4, 5};
		numArr1 = numArr2;
		System.out.println(Arrays.toString(numArr1));
		System.out.println(Arrays.toString(numArr2));
		
		numArr1[2] = 30;
		
		System.out.println(Arrays.toString(numArr1));
		System.out.println(Arrays.toString(numArr2));
		
		System.out.println(numArr1[0]);
		
		//얕은 복사
		System.out.println("numArr1의 해시코드 : " + System.identityHashCode(numArr1));
		System.out.println("numArr1의 해시코드 : " + System.identityHashCode(numArr2));
		
		int[] numArr3 = null;
		int[] numArr4 = {100, 200, 300};
		
		numArr3 = Arrays.copyOf(numArr4, 3);
		
		System.out.println(Arrays.toString(numArr3));
		System.out.println(Arrays.toString(numArr4));
		
		numArr3[1] = 20;
		
		System.out.println(Arrays.toString(numArr3));
		System.out.println(Arrays.toString(numArr4));
		
		//깊은 복사
		System.out.println("numArr1의 해시코드 : " + System.identityHashCode(numArr3));
		System.out.println("numArr1의 해시코드 : " + System.identityHashCode(numArr4));
		
		String str1 = null;
		str1 = "kor";
		
		String str2 = "kor";
		
		System.out.println("str1의 해시코드 : " + System.identityHashCode(str1));
		System.out.println("str2의 해시코드 : " + System.identityHashCode(str2));
	}

}
	