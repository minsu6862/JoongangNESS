package com.minsu.home.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minsu.home.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
