package com.minsu.home.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minsu.home.entity.SiteUser;
import com.minsu.home.repository.UserRepository;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/signup")
	public ResponseEntity<?> signup(@RequestBody SiteUser req) {
		//사용자 이름(username)이 DB에 이미 존재하는지 확인
		if(userRepository.findByUsername(req.getUsername()).isPresent()) {
			//참이면->이미지 해당 username(아이디)가 존재하므로 가입 불가
			//거짓이면->가입 가능
			return ResponseEntity.badRequest().body("이미 존재하는 사용자명 입니다."); //가입실패 -> 에러 메시지
		}
		req.setPassword(passwordEncoder.encode(req.getPassword())); 
		//비밀번호 암호화해서 엔티티에 다시 넣기
		userRepository.save(req);
		
		return ResponseEntity.ok("회원가입 성공!"); //가입성공 -> 성공메시지
		//return ResponseEntity.ok(req); //가입성공 후 해당 엔티티 반환
	}
	
	@GetMapping("/me") //현재 로그인한 사용자 정보를 가져오는 요청(나 자신의 정보->현재 로그인한 유저의 정보)
	public ResponseEntity<?> me(Authentication auth) {
		return ResponseEntity.ok(Map.of("username", auth.getName()));
	}
	
}