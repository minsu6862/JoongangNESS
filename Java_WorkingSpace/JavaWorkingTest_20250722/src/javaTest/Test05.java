package javaTest;

import java.util.ArrayList;

public class Test05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Member> memList = new ArrayList<Member>();
		
		memList.add(new Member("1", "pinkTiger"));
		memList.add(new Member("2", "blackCat"));
		memList.add(new Member("3", "whiterDog"));
		
		for (int i = 0; i < memList.size(); i++) {
			System.out.print(memList.get(i).pw+ " / ");
		}
	}

}

class Member {
	String id, pw;

	public Member(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
}