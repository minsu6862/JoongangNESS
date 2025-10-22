package com.minsu.board.user;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.minsu.board.post.Post;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String username;
	private String password;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)	
	//Post와 연관관계를 설정할 때 post들의 주인이 누구냐를 설정
	//cascade = CascadeType.ALL -> user를 저장하거나 삭제하면 post도 함께 저장되거나 삭제됨
	@JsonManagedReference
	private List<Post> posts;
}
