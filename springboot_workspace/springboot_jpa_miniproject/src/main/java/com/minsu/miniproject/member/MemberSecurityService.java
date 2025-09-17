package com.minsu.miniproject.member;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MemberSecurityService implements UserDetailsService {

	@Autowired
	private MemberRepository memberRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		Optional<Member> _member = memberRepository.findByMemberName(userName);
		
		if(_member.isEmpty()) {
			throw new UsernameNotFoundException("입력하신 사용자를 찾을 수 없습니다.");
		}
		
		Member member = _member.get();
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		if("admin".equals(userName)) {
			authorities.add(new SimpleGrantedAuthority(MemberRole.ADMIN.getValue()));
		} else {
			authorities.add(new SimpleGrantedAuthority(MemberRole.USER.getValue()));
		}
		
		return new User(member.getMemberName(), member.getPassword(), authorities);
	}

}
