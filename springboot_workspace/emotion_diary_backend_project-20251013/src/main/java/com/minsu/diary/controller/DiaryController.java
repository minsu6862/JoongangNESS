package com.minsu.diary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minsu.diary.entity.Diary;
import com.minsu.diary.service.DiaryService;

@RestController
@RequestMapping("/api/diary")
@CrossOrigin(origins = "http://localhost:3000")
public class DiaryController {
	
	@Autowired
	private DiaryService diaryService;
	
	//새 일기 쓰기
	@PostMapping
	public Diary diaryCreate(@RequestBody Diary diary) {
		//@RequestBody Diary diary -> 프론트에서 넘어온 content, date, emotionId 받아 줌
		return diaryService.writeDiary(diary); //db에 삽입된 새 일기 엔티티를 반환
	}
	
	//모든 일기 가져오기
	@GetMapping
	public List<Diary> getAllDiary() {
		return diaryService.getDiaryList();
	}
	
	//특정 id의 일기 가져오기
	@GetMapping("/{id}")
	public Diary getByIdDiary(@PathVariable("id") Long id) {
		return diaryService.getDiary(id); //null 아니면 일기 엔티티가 반환
	}
	
	@PutMapping("/{id}")
	public updateDiary(@PathVariable("id") Long id, @RequestBody Diary diary) {
		
	}

}