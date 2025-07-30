package ch13_01;

import java.util.HashSet;
import java.util.Set;

public class SetTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Set<MemberDTO> set = new HashSet<MemberDTO>();
		
		MemberDTO member1 = new MemberDTO("tiger", "1234", "홍길동", 28);
		
		set.add(member1);
		set.add(member1);
		set.add(member1);
		
		System.out.println(set.size());	//아무리 많이 넣어도 중복이기에 set의 사이즈는 1
		
	}

}
