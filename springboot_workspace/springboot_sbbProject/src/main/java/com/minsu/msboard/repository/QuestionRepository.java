package com.minsu.msboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minsu.msboard.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

	public Question findBySubject(String subject);
}
