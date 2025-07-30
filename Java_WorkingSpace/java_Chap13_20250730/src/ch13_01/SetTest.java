package ch13_01;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> set1 = new HashSet<String>();
		
		set1.add("Kor");
		set1.add("Japan");
		set1.add("USA");
		set1.add("China");
		
		System.out.println(set1.size());
		
		Iterator<String> iter = set1.iterator();
		
		while(iter.hasNext()) {
			String str = iter.next();
			System.out.println();
		}
	}

}
