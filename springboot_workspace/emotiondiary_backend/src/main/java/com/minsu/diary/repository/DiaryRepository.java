package com.minsu.diary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minsu.diary.entity.Diary;

public interface DiaryRepository extends JpaRepository<Diary, Long>{

}
