package com.minsu.miniproject.member;

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
@Table(name = "member")
@SequenceGenerator(name = "MEMBER_SEQ_GENERATOR", sequenceName = "MEMBER_SEQ", initialValue = 1, allocationSize = 1)
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "MEMBER_SEQ_GENERATOR")
	private int memberId;
	
	@Column(name = "memberName", unique = true)
	private String memberName;
	
	private String password;
	
	@Column(name = "age", unique = true)
	private int age;
}
