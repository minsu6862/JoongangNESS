package com.minsu.miniproject.comment;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minsu.miniproject.DataNotFoundException;
import com.minsu.miniproject.board.Board;
import com.minsu.miniproject.member.Member;

@Service
public class CommentService {

	@Autowired
	private CommentRepository commentRepository;
	
	public Comment write(Board board, String content, Member author) {
		Comment comment = new Comment();
		comment.setContent(content);
		comment.setCreateDate(LocalDateTime.now());
		comment.setBoard(board);
		comment.setMember(author);
		commentRepository.save(comment);
		
		return comment;
	}
	
	public Comment getComment(Integer id) {
		Optional<Comment> _comment = commentRepository.findById(id);
		
		if(_comment.isPresent()) {
			return _comment.get();
		} else {
			throw new DataNotFoundException("해당 댓글이 존재하지 않습니다.");
		}
	}
	
	public void modify(Comment comment, String content) {
		comment.setContent(content);
		comment.setModifyDate(LocalDateTime.now());
		commentRepository.save(comment);
	}
	
	public void delete(Comment comment) {
		commentRepository.delete(comment);
	}
}
