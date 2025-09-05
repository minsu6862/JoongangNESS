package com.minsu.member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.minsu.member.dao.MemberDao;
import com.minsu.member.dto.MemberDto;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
//테스트용으로 사용할 DB가 설정된 설정 파일을 불러옴->연습용 DB를 테스트에 사용 가능
public class MemberTest {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	@DisplayName("모든 회원 리스트 불러오기 테스트")
	public void memberList() {
		MemberDao memberDao = sqlSession.getMapper(MemberDao.class);
		List<MemberDto> memberDtos = memberDao.listMemberDao();
		
		for(MemberDto mDto : memberDtos) {
			System.out.println("회원번호 : " + mDto.getMembernum());
			System.out.println("회원아이디 : " + mDto.getMemberid());
			System.out.println("회원비번 : " + mDto.getMemberpw());
			System.out.println("회원이름 : " + mDto.getMembername());
			System.out.println("회원가입일 : " + mDto.getMemberdate());
			System.out.println("===========================");
		}
	}
	
	@Test
	@DisplayName("회원 아이디로 회원 삭제 테스트")
	public void deleteMember() {
		MemberDao memberDao = sqlSession.getMapper(MemberDao.class);
		memberDao.deleteMemberDao("tiger77");
		
		memberList(); //회원 리스트 다시 출력
	}
	
	@Test
	@DisplayName("회원 가입 테스트")
	public void joinMember() {
		MemberDao memberDao = sqlSession.getMapper(MemberDao.class);
		memberDao.joinMemberDao("tiger123", "88888", "김팔팔");
		
		memberList();
	}

}
