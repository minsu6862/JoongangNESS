package ch10_01;

import java.util.ArrayList;
import java.util.List;

public class IndexOutOfBoundsExceptionTest {

	public static void main(String[] args) {
		// 불가능한 배열 요소를 호출할때 발생하는 에러
		int[] arr = { 10, 20, 30, 40 };
		// System.out.println(arr[4]);
		
		List<String> list = new ArrayList<String>();
		list.add("Korea");
		list.add("Japan");
		
		System.out.println(list.get(2));
		
	}

}
