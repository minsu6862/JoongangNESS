package chap02_03;

public class ChangeType1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte byteVar1 = 50;
		int intVar1;
		
		intVar1 = byteVar1;
		
		short shortVar1;
		
		shortVar1 = (byte)intVar1;
		
		System.out.println(shortVar1);
		
		char charVar1;
		charVar1 = (char)intVar1;
		System.out.println(charVar1);
		
		double doubleVar1 = 3.14;
		double doubleVar2;
		int intVar2 = (int) doubleVar1;
		int intVar3 = 10;
		System.out.println(intVar2);
		doubleVar2 = intVar3;
		System.out.println(doubleVar2);
		
		double doubleVar3 = (5 / 2 + 3.0) / 2;
		System.out.println(doubleVar3);
	}

}
