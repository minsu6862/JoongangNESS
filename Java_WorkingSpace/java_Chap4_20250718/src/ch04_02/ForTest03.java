package ch04_02;

public class ForTest03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 1; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				System.out.print("*");	
			}
			System.out.println();
		}
		
		System.out.println("-----------------------------------------------------");
		
		for(int i = 1; i < 5; i++) {
			for(int j = 0; j < i; j++) {
				System.out.print("*");	
			}
			System.out.println();
		}
		
		for(int i = 1; i < 5; i++) {
			for(int j = 5; j > i; j--) {
				System.out.print("*");	
			}
			System.out.println();
		}
	}

}
