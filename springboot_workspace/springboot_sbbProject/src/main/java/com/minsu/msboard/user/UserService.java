package com.minsu.msboard.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.minsu.msboard.DataNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	//유저 등록 서비스
	public SiteUser create(String username, String email, String password) {
		SiteUser user = new SiteUser();
		user.setUsername(username);
		user.setEmail(email);
		//BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String cryptPassword = passwordEncoder.encode(password);	//비밀번호 암호화
		user.setPassword(cryptPassword);	//비밀번호를 암호화한 후 암호문을 DB에 입력
		userRepository.save(user);
		
		return user;
	}
	
	//유저 아이디로 엔티티 가져오기
	public SiteUser getUser(String username) {
		Optional<SiteUser> _siteUser = userRepository.findByUsername(username);
		
		if(_siteUser.isPresent()) {
			SiteUser siteUser = _siteUser.get();
			return siteUser;
		} else {
			throw new DataNotFoundException("해당 유저는 존재하지 않습니다.");
		}
	}
}
