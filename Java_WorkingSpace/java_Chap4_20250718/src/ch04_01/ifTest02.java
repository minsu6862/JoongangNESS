package ch04_01;

import java.util.Random;

public class ifTest02 {
	public static void main(String[] args) {
		int x = (int) (Math.random() * 6 + 1);
		
		if(x == 6) {
			System.out.println("주사위 값은 6입니다!");
		} else if(x == 5) {
			System.out.println("주사위 값은 5입니다!");
		} else if(x == 4) {
			System.out.println("주사위 값은 4입니다!");
		} else if(x == 3) {
			System.out.println("주사위 값은 3입니다!");
		} else if(x == 2) {
			System.out.println("주사위 값은 2입니다!");
		} else {
			System.out.println("주사위 값은 1입니다!");
		}
	}
}
