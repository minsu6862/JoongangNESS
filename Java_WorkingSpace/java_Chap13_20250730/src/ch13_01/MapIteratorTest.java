package ch13_01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapIteratorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("이름", "홍길동");
		map.put("직업", "개발자");
		map.put("성별", "남자");
		
		Iterator<String>iter = map.keySet().iterator();
		
		while(iter.hasNext()) {
			String key = iter.next();
			System.out.println(map.get(key));	//key값을 이용해 value값 가져오기
		}
		
		System.out.println("=======================");
		
		Iterator<Map.Entry<String, String>> iter2 = map.entrySet().iterator();
		while(iter.hasNext()) {
			Map.Entry<String, String> entry = iter2.next();
			System.out.println(entry.getKey());	//key값 가져오기
			System.out.println(entry.getValue());	//value값 가져오기
		}
			
		}

}
