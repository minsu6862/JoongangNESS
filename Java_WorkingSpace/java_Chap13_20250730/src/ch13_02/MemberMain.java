package ch13_02;

import java.util.Iterator;
import java.util.List;

public class MemberMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MemberDao dao = new MemberDao();
		List<MemberDto> list = dao.getMemberDao();
		
		Iterator<MemberDto> iter = list.iterator();
		while(iter.hasNext()) {
			MemberDto  memDto = iter.next();
			System.out.println("회원 아이디 : " + memDto.getId() + ", 비밀번호 : " + memDto.getPw() + ", 이름 : " + memDto.getName() + ", 이메일 : " + memDto.getEmail());
		}
	}

}
