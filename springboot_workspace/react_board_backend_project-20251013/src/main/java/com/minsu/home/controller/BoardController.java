package com.minsu.home.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.minsu.home.dto.BoardDto;
import com.minsu.home.entity.Board;
import com.minsu.home.entity.SiteUser;
import com.minsu.home.repository.BoardRepository;
import com.minsu.home.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/board")
public class BoardController {

	@Autowired
	private BoardRepository boardRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	/*
	//전체 게시글 조회 -> 페이징 처리 x
	@GetMapping
	public List<Board> list() {
		return boardRepository.findAll();
	}*/
	
	//게시글 페이징 처리
	@GetMapping
	public ResponseEntity<?> pagingList(@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "10") int size) {
		
		if (page < 0) {
			page = 0;
		}
		
		if (size <= 0) {
			size = 10;
		}
		
		//Pageable 객체 생성 -> findAll에서 사용
		Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
		Page<Board> boardPage = boardRepository.findAll(pageable);	//DB에서 페이징된 게시글만 조회
		//boardPage가 포함하는 정보 ->
		//1. 해당 페이지 글 리스트 -> boardPage.getContent()
		//2. 현재 페이지 번호 -> boardPage.getNumber()
		//3. 전체 페이지 수 -> boardPage.getTotalPages()
		//4. 전체 게시글 수 -> boardPage.getTotalElements()
		
		Map<String, Object> pagingResponce = new HashMap<>();
		pagingResponce.put("posts", boardPage.getContent()); //페이징된 현재 페이지에 해당하는 게시글 리스트 10개
		pagingResponce.put("currentPage", boardPage.getNumber()); //현재 페이지 번호
		pagingResponce.put("totalPages", boardPage.getTotalPages()); //모든 페이지의 수
		pagingResponce.put("totalItems", boardPage.getTotalElements()); //게시판에 올라와 있는 모든 글 수(Long)
		//{"currentPage":3, totalPages:57}
		
		return ResponseEntity.ok(pagingResponce);
	}
	
	/*
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
	}*/
	
	//게시글 작성(유효성 체크-> 제목과 내용은 1글자 이상)
	@PostMapping
	public ResponseEntity<?> write(@Valid @RequestBody BoardDto boardDto, BindingResult bindingResult, Authentication auth) {
		
		//사용자의 로그인 여부 확인
		if (auth == null) {	//참이면 로그인x -> 글쓰기 권한 없음 -> 에러코드 반환
			return ResponseEntity.status(401).body("로그인이 필요합니다");
		}
		
		//Spring Validation 결과 처리
		if(bindingResult.hasErrors()) {	//참이면 에러, 유효성 체크 실패 -> err
			Map<String, String> errors = new HashMap<>();
			bindingResult.getFieldErrors().forEach(
				err -> {
					errors.put(err.getField(), err.getDefaultMessage());
//					ex)회원가입 -> username: abc, password: 123
//					
				}
			);
					
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
		}
		
		SiteUser siteUser = userRepository.findByUsername(auth.getName())
				.orElseThrow(() -> new UsernameNotFoundException("사용자 없음"));
		
		Board board = new Board();
		board.setTitle(boardDto.getTitle()); //유저가 입력한 글 제목
		board.setContent(boardDto.getContent()); //유저가 입력한 글 제목
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
    public ResponseEntity<?> update(@PathVariable("id") Long id, @Valid @RequestBody BoardDto boardDto, BindingResult bindingResult, Authentication auth) {

        //Spring Validation 결과 처리
        if(bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(
                err -> {
                    errors.put(err.getField(), err.getDefaultMessage());
                }
            );
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
        }

        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("해당 글이 존재하지 않습니다."));

        SiteUser siteUser = userRepository.findByUsername(auth.getName())
                .orElseThrow(() -> new UsernameNotFoundException("사용자 없음"));

        if (!board.getAuthor().getUsername().equals(siteUser.getUsername())) {
            return ResponseEntity.status(403).body("수정 권한이 없습니다.");
        }

        // 제목과 내용 수정
        board.setTitle(boardDto.getTitle());
        board.setContent(boardDto.getContent());

        boardRepository.save(board);

        return ResponseEntity.ok("게시글이 수정되었습니다.");
    }
}
