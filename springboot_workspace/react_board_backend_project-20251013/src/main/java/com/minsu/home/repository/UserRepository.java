package com.minsu.home.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minsu.home.entity.SiteUser;

public interface UserRepository extends JpaRepository<SiteUser, Long> {

	public Optional<SiteUser> findByUsername(String username);
}
