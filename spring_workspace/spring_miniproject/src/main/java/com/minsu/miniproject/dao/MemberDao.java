package com.minsu.miniproject.dao;

public interface MemberDao {
	
	public int memberJoin(String memberid, String memberpw, String membername);
	public int memberIdCheck(String memberid); //아이디 존재 여부 확인 메서드
	public int memberLogin(String memberid, String memberpw); //로그인 확인 메서드
	
	// 회원 아이디로 회원명 조회
    public String getMemberName(String memberId);
}
