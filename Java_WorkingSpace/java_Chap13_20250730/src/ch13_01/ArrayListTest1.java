package ch13_01;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> str = new ArrayList<String>();
		
		str.add("Kor");
		str.add("Jap");
		str.add("Eng");
		str.add(1, "JPN");
		
		System.out.println(str);
		
		str.remove(2);
		
		System.out.println(str);
	}

}
