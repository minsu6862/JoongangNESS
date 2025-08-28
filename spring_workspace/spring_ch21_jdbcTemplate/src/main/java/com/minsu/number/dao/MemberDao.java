package com.minsu.number.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.minsu.number.dto.MemberDto;

@Repository
public class MemberDao {

	@Autowired	//DI -> 컨테이너에 생성된 bean(객체)를 자동 주입
	JdbcTemplate jdbcTemplate;
	
	//Insert문 구현 - 회원추가
	public void insertMember(String member_id, String member_pw, String member_name, int member_age) {
		String sql = "INSERT INTO membertbl VALUES (?, ?, ?, ?)";
		
		jdbcTemplate.update(sql, member_id, member_pw, member_name, member_age);
	}
	
	//DELETE문 구현 - 회원추가
	public void deleteMember(String member_id, String member_pw, String member_name, int member_age) {
		String sql = "DELETE FROM membertbl WHERE member_id = ?";
			
		jdbcTemplate.update(sql, member_id);
	}
	
	//UPDATE문 구현 - 회원추가
	public void updateMember(String member_id, String member_pw, String member_name, int member_age) {
		String sql = "UPDATE membertbl SET member_pw = ? member_name = ?, member_age = ? WHERE member_id = ?";
				
		jdbcTemplate.update(sql, member_pw, member_name, member_age, member_id);
	}
	
	//SELECT문 구현
	public MemberDto searchMember(String member_id) {
		String sql = "SELECT * FROM membertbl WHERE member_id = ?";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<MemberDto>(MemberDto.class), member_id);
		//return memberDto;
	}
	
	//SELECT문 구현
	public List<MemberDto> searchMembers() {
		String sql = "SELECT * FROM membertbl";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<MemberDto>(MemberDto.class));
		//return memberDto;
	}
	
	
}
