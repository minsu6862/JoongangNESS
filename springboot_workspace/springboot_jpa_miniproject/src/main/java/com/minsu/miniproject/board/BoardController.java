package com.minsu.miniproject.board;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import com.minsu.miniproject.SecurityConfig;
import com.minsu.miniproject.SpringbootJpaMiniprojectApplication;
import com.minsu.miniproject.comment.Comment;
import com.minsu.miniproject.comment.CommentForm;
import com.minsu.miniproject.comment.CommentService;
import com.minsu.miniproject.member.Member;
import com.minsu.miniproject.member.MemberService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/board")
public class BoardController {

    private final CommentService commentService;
	
	private final SecurityConfig securityConfig;
	
	private final SpringbootJpaMiniprojectApplication springbootJpaMiniprojectApplication;
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private MemberService memberService;
	
	public BoardController(SpringbootJpaMiniprojectApplication springbootJpaMiniprojectApplication, SecurityConfig securityConfig, CommentService commentService) {
		this.springbootJpaMiniprojectApplication = springbootJpaMiniprojectApplication;
		this.securityConfig = securityConfig;
		this.commentService = commentService;
	}
	
	@GetMapping(value = "/list")
	public String list(Model model, @RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "kw", defaultValue = "") String kw) {
		Page<Board> paging = boardService.getPageBoard(page, kw);
		
		model.addAttribute("paging", paging);
		model.addAttribute("kw", kw);
		
		return "board_list";
	}
	
	@GetMapping(value = "/write")
	public String boardWrite(BoardForm boardForm) {
		
		return "board_form";
	}
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping(value = "/write")
	public String boardWrite(@Valid BoardForm boardForm, BindingResult bindingResult, Principal principal) {
		if(bindingResult.hasErrors()) {
			return "board_form";
		}
		
		Member member = memberService.getMember(principal.getName());
		
		boardService.write(boardForm.getSubject(), boardForm.getContent(), member);
		
		return "redirect:/board/list";
	}
	
	@GetMapping(value = "/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id, CommentForm commentForm) {
		
		boardService.hit(boardService.getBoard(id));
		
		Board board = boardService.getBoard(id);
		model.addAttribute("board", board);
		
		return "board_detail";
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping(value = "/modify/{id}")
	public String boardModify(BoardForm boardForm, @PathVariable("id") Integer id, Principal principal) {
		Board board = boardService.getBoard(id);
		
		if(!board.getAuthor().getMemberName().equals(principal.getName())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정 권한이 없습니다.");
		}
		
		boardForm.setSubject(board.getSubject());
		boardForm.setContent(board.getContent());
		
		return "board_form";
	}
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping(value = "/modify/{id}")
	public String boardModify(@Valid BoardForm boardForm, BindingResult bindingResult, @PathVariable("id") Integer id, Principal principal) {
		
		if(bindingResult.hasErrors()) {
			return "board_form";
		}
		
		Board board = boardService.getBoard(id);
		
		if(!board.getAuthor().getMemberName().equals(principal.getName())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정 권한이 없습니다.");
		}
		
		boardService.modify(board, boardForm.getSubject(), boardForm.getContent());
		
		return String.format("redirect:/board/detail/%s", id);
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping(value = "/delete/{id}")
	public String boardDelete(@Valid BoardForm boardForm, BindingResult bindingResult, @PathVariable("id") Integer id, Principal principal) {
		
		Board board = boardService.getBoard(id);
		
		if(!board.getAuthor().getMemberName().equals(principal.getName())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "삭제 권한이 없습니다.");
		}
		
		boardService.delete(board);
		
		return "redirect:/board/list";
	}
	
}
