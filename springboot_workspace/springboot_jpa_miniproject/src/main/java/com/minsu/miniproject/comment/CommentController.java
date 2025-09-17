package com.minsu.miniproject.comment;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import com.minsu.miniproject.board.Board;
import com.minsu.miniproject.board.BoardForm;
import com.minsu.miniproject.board.BoardService;
import com.minsu.miniproject.member.Member;
import com.minsu.miniproject.member.MemberService;

import jakarta.validation.Valid;

@RequestMapping("/comment")
@Controller
public class CommentController {
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private MemberService memberService;
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping(value = "/write/{id}")
	public String writeComment(Model model, @PathVariable("id") Integer id, @Valid CommentForm commentForm, BindingResult bindingResult, Principal principal) {
		Board board = boardService.getBoard(id);
		Member member = memberService.getMember(principal.getName());
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("board", board);
			return "board_detail";
		}
		
		Comment comment = commentService.write(board, commentForm.getContent(), member);
		
		return String.format("redirect:/board/detail/%s#comment_%s", id, comment.getId());
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping(value = "/modify/{id}")
	public String answerModify(CommentForm commentForm, @PathVariable("id") Integer id, Principal principal) {
		Comment comment = commentService.getComment(id);
		
		if(!comment.getMember().getMemberName().equals(principal.getName())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정 권한이 없습니다.");
		}
		
		commentForm.setContent(comment.getContent());
		return "comment_form";
	}
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping(value = "/modify/{id}")
	public String answerModify(@Valid CommentForm commentForm, BindingResult bindingResult, @PathVariable("id") Integer id, Principal principal) {
		if(bindingResult.hasErrors()) {
			return "comment_form";
		}
		
		Comment comment = commentService.getComment(id);
		
		if(!comment.getMember().getMemberName().equals(principal.getName())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정 권한이 없습니다.");
		}
		
		commentService.modify(comment, commentForm.getContent());
		
		return String.format("redirect:/board/detail/%s", comment.getBoard().getId());
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping(value = "/delete/{id}")
	public String commentDelete(@PathVariable("id") Integer id, Principal principal) {
		
		Comment comment = commentService.getComment(id);
		
		if(!comment.getMember().getMemberName().equals(principal.getName())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "삭제 권한이 없습니다.");
		}
		
		commentService.delete(comment);
		
		return String.format("redirect:/board/detail/%s", comment.getBoard().getId());
	}
}
