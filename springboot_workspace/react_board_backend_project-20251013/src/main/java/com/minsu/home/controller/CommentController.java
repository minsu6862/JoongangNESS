package com.minsu.home.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minsu.home.dto.CommentDto;
import com.minsu.home.entity.Board;
import com.minsu.home.entity.Comment;
import com.minsu.home.entity.SiteUser;
import com.minsu.home.repository.BoardRepository;
import com.minsu.home.repository.CommentRepository;
import com.minsu.home.repository.UserRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BoardRepository boardRepository;

    // 댓글 작성
    @PostMapping("/{boardId}")
    public ResponseEntity<?> writeComment(@PathVariable("boardId") Long boardId,
            @Valid @RequestBody CommentDto commentDto, BindingResult bindingResult, Authentication auth) {
        
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
    	
    	//원 게시글의 존재 여부 확인
        Optional<Board> _board = boardRepository.findById(boardId);
        if (_board.isEmpty()) {
        	Map<String, String> error = new HashMap<>();
        	error.put("boardError", "해당 게시글이 존재하지 않습니다.");
            return ResponseEntity.badRequest().body(error);
        }

        SiteUser user = userRepository.findByUsername(auth.getName()).orElseThrow();

        Comment comment = new Comment();
        comment.setBoard(_board.get());
        comment.setAuthor(user);
        comment.setContent(commentDto.getContent());
        comment.setCreateDate(LocalDateTime.now());

        commentRepository.save(comment);

        return ResponseEntity.ok(comment);
    }

    //댓글 조회 -> 댓글이 달린 원 게시글의 id가 필요 -> 게시글 id로 댓글 조회
    @GetMapping("/{boardId}")
    public ResponseEntity<?> getComments(@PathVariable("boardId") Long boardId) {

        Optional<Board> _board = boardRepository.findById(boardId);
        if (_board.isEmpty()) {
            return ResponseEntity.badRequest().body("해당 게시글이 존재하지 않습니다.");
        }

        List<Comment> comments = commentRepository.findByBoard(_board.get());

        return ResponseEntity.ok(comments);
    }

    // 댓글 수정
    @PutMapping("/{boardId}/{commentId}")
    public ResponseEntity<?> updateComment(@PathVariable("boardId") Long boardId,
            @PathVariable("commentId") Long commentId,
            @Valid @RequestBody CommentDto commentDto,
            BindingResult bindingResult,
            Authentication auth) {

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

        // 댓글 존재 여부 확인
        Optional<Comment> _comment = commentRepository.findById(commentId);
        if (_comment.isEmpty()) {
            return ResponseEntity.badRequest().body("해당 댓글이 존재하지 않습니다.");
        }

        Comment comment = _comment.get();

        // 작성자 본인 확인
        if (!comment.getAuthor().getUsername().equals(auth.getName())) {
            return ResponseEntity.status(403).body("댓글 수정 권한이 없습니다.");
        }

        // 댓글 수정
        comment.setContent(commentDto.getContent());
        commentRepository.save(comment);

        // 성공 메시지만 반환 (Comment 객체 직렬화 에러 방지)
        Map<String, String> response = new HashMap<>();
        response.put("message", "댓글이 수정되었습니다.");
        return ResponseEntity.ok(response);
    }

    // 댓글 삭제
    @DeleteMapping("/{boardId}/{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable("boardId") Long boardId,
            @PathVariable("commentId") Long commentId,
            Authentication auth) {

        // 댓글 존재 여부 확인
        Optional<Comment> _comment = commentRepository.findById(commentId);
        if (_comment.isEmpty()) {
            return ResponseEntity.badRequest().body("해당 댓글이 존재하지 않습니다.");
        }

        Comment comment = _comment.get();

        // 작성자 본인 확인
        if (!comment.getAuthor().getUsername().equals(auth.getName())) {
            return ResponseEntity.status(403).body("댓글 삭제 권한이 없습니다.");
        }

        // 댓글 삭제
        commentRepository.delete(comment);

        return ResponseEntity.ok("댓글이 삭제되었습니다.");
    }
}