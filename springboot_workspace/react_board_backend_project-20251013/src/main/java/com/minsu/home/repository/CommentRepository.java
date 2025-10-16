package com.minsu.home.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minsu.home.entity.Board;
import com.minsu.home.entity.Comment;
import java.util.List;


public interface CommentRepository extends JpaRepository<Comment, Long> {
	//댓글이 달린 원 게시글로 댓글리스트 반환
	List<Comment> findByBoard(Board board);
}
