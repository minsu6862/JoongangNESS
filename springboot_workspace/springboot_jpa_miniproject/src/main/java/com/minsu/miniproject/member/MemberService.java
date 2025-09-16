package com.minsu.miniproject.member;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.minsu.miniproject.DataNotFoundException;

@Service
public class MemberService {

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
    MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

	public Member create(String memberName, String password, int age) {
		Member member = new Member();
		member.setMemberName(memberName);
		String cryptPassword = passwordEncoder.encode(password);	//비밀번호 암호화
		member.setPassword(cryptPassword);
		member.setAge(age);
		
		memberRepository.save(member);
		
		return member;
	}
	
	public Member getMember(String memberName) {
		Optional<Member> _member = memberRepository.findByMemberName(memberName);
		
		if(_member.isPresent()) {
			Member member = _member.get();
			return member;
		} else {
			throw new DataNotFoundException("존재하지 않는 유저입니다.");
		}
	}
}
