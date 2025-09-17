package com.minsu.miniproject.board;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BoardRepository extends JpaRepository<Board, Integer> {

	@Query(
			value = "SELECT * FROM ( " +
	                 " SELECT q.*, ROWNUM rnum FROM ( " +
	                 "   SELECT * FROM board ORDER BY create_date DESC " +
	                 " ) q WHERE ROWNUM <= :endRow " +
	                 ") WHERE rnum > :startRow",
	         nativeQuery = true)
	List<Board> findBoardWithPaging(@Param("startRow") int startRow, @Param("endRow") int endRow);
}
