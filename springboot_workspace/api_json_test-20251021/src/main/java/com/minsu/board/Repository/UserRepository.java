package com.minsu.board.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minsu.board.user.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
