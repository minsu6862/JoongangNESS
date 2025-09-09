package com.minsu.msboard.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "siteuser")	//실제로 매핑될 데이터베이스의 테이블 이름 설정
@SequenceGenerator(
		name = "USER_SEQ_GENERATOR",	//JPA 내부 시퀀스 이름
		sequenceName = "USER_SEQ",		//실제 시퀀스 이름
		initialValue = 1,	//시퀀스 시작값
		allocationSize = 1	//시퀀스 증가치
		)
public class SiteUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "USER_SEQ_GENERATOR")
	private Long id;
	
	@Column(name = "username", unique = true)
	private String username;
	
	private String password;
	
	@Column(name="email", unique = true)
	private String email;
}
