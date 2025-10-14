package com.minsu.home.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minsu.home.entity.Board;
import com.minsu.home.entity.SiteUser;
import com.minsu.home.repository.BoardRepository;
import com.minsu.home.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/board")
public class BoardController {

	@Autowired
	private BoardRepository boardRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	//전체 게시글 조회
	@GetMapping
	public List<Board> list() {
		return boardRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<?> write(@RequestBody Board req, Authentication auth) {
		
		SiteUser siteUser = userRepository.findByUsername(auth.getName())
				.orElseThrow(() -> new UsernameNotFoundException("사용자 없음"));
		
		Board board = new Board();
		board.setTitle(req.getTitle()); //유저가 입력한 글 제목
		board.setContent(req.getContent()); //유저가 입력한 글 제목
		board.setAuthor(siteUser);	//유저 정보
		
		boardRepository.save(board);
		
		return ResponseEntity.ok(null);
	}
	
	//특정 게시글 번호(id)로 글 불러오기
	//RequestBody는 통째로 받는것, pathVariable은 특정 id 1개만 불러오기
	@GetMapping("/{id}")
	public ResponseEntity<?> boardDetail(@PathVariable("id") Long id) {
//		Board board = boardRepository.findById(id)
//				.orElseThrow(() -> new EntityNotFoundException("해당 글 없음"));	//해당글 id로 불러오기
		Optional<Board> board = boardRepository.findById(id);
		
		if(board.isPresent()) {
			
			return ResponseEntity.ok(board.get());	//해당 id글을 반환
		} else {
			
			return ResponseEntity.status(404).body("해당 게시글은 존재하지 않습니다.");
		}
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id, Authentication auth) {
	    
	    Board board = boardRepository.findById(id)
	            .orElseThrow(() -> new EntityNotFoundException("해당 글이 존재하지 않습니다."));
	    
	    SiteUser siteUser = userRepository.findByUsername(auth.getName())
	            .orElseThrow(() -> new UsernameNotFoundException("사용자 없음"));
	    
	    if (!board.getAuthor().getUsername().equals(siteUser.getUsername())) {
	        return ResponseEntity.status(403).body("삭제 권한이 없습니다.");
	    }
	    
	    boardRepository.delete(board);
	    
	    return ResponseEntity.ok("게시글이 삭제되었습니다.");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Board req, Authentication auth) {

	    Board board = boardRepository.findById(id)
	            .orElseThrow(() -> new EntityNotFoundException("해당 글이 존재하지 않습니다."));

	    SiteUser siteUser = userRepository.findByUsername(auth.getName())
	            .orElseThrow(() -> new UsernameNotFoundException("사용자 없음"));

	    if (!board.getAuthor().getUsername().equals(siteUser.getUsername())) {
	        return ResponseEntity.status(403).body("수정 권한이 없습니다.");
	    }

	    // 제목과 내용 수정
	    board.setTitle(req.getTitle());
	    board.setContent(req.getContent());
	    
	    boardRepository.save(board);

	    return ResponseEntity.ok("게시글이 수정되었습니다.");
	}
}
