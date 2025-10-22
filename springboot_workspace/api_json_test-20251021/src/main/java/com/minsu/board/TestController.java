package com.minsu.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minsu.board.Repository.PostRepository;
import com.minsu.board.Repository.UserRepository;
import com.minsu.board.post.Post;
import com.minsu.board.user.User;
import com.minsu.board.usertest.UserTest;
import com.minsu.board.usertest.UserTest1;
import com.minsu.board.usertest.UserTest2;
import com.minsu.board.usertest.UserTest3;
import com.minsu.board.usertest.UserTest4;

@RestController
public class TestController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@GetMapping("/usertest")
	public UserTest userTest() {
		UserTest userTest = new UserTest();
		userTest.setUsername("tiger");
		userTest.setPassword("12345");
		return userTest;
	}
	
	@GetMapping("/usertest1")
	public UserTest1 userTest1() {
		UserTest1 userTest1 = new UserTest1();
		userTest1.setUsername("tiger");
		userTest1.setPassword("12345");
		return userTest1;
	}
	
	@GetMapping("/usertest2")
	public UserTest2 userTest2() {
		UserTest2 userTest2 = new UserTest2();
		userTest2.setUsername("tiger");
		userTest2.setPassword("12345");
		userTest2.setEmail("tiger@abc.com");
		return userTest2;
	}
	
	@GetMapping("/usertest3")
	public UserTest3 userTest3() {
		UserTest3 userTest3 = new UserTest3();
		userTest3.setUsername("tiger");
		userTest3.setPassword("12345");
		return userTest3;
	}
	
	@GetMapping("/usertest4")
	public UserTest4 userTest4() {
		UserTest4 userTest4 = new UserTest4();
		userTest4.setUsername("tiger");
		userTest4.setPassword("12345");
		return userTest4;
	}
	
	//====================== Entity 적용 ========================
	
	@GetMapping("/users")	//모든 유저를 반환하는 요청 처리
	public List<User> getUsers() {
		return userRepository.findAll();	//모든 유저 반환
	}
	//순환 참조 에러 발생 User -> Post -> User -> Post.. 무한루프 호출
	
	//마찬가지로 무한루프 오류
	@GetMapping("/posts")	//모든 게시글을 반환하는 요청 처리
	public List<Post> getPosts() {
		return postRepository.findAll();	//모든 게시글 가져오기
	}
}
