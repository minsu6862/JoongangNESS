package ch13_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class HashTableTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<String, String> map = new HashMap<String, String>();
		
		map.put("tiger", "12345");
		map.put("lion", "88888");
		map.put("blackcat", "99999");
		map.put("whitedog", "77777");
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("아이디 : ");
			String id = scan.nextLine();
			
			System.out.println("패스워드 : ");
			String pw = scan.nextLine();
			
			System.out.println("===============================");
			
			if(map.containsKey(id) && map.get(id).equals(pw)) {
				System.out.println("로그인 성공");
			} else {
				System.out.println("입력이 틀렸습니다");
			}
					
		}
	}

}
