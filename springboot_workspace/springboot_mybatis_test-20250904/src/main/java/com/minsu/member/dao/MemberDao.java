package com.minsu.member.dao;

import java.util.List;

import com.minsu.member.dto.MemberDto;

public interface MemberDao {

	public void joinMemberDao(String memberid, String memberpw, String membername);
	public List<MemberDto> listMemberDao();
	public void deleteMemberDao(String memberid);
}
