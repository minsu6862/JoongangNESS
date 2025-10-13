package com.minsu.diary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minsu.diary.entity.Diary;
import com.minsu.diary.repository.DiaryRepository;

@Service
public class DiaryService {
	
	@Autowired
	private DiaryRepository diaryRepository;
	
	//새로운 일기 쓰기
	public Diary writeDiary(Diary diary) {
		return diaryRepository.save(diary); //db에 넣고 해당 엔티티를 반환
	}
	
	//모든 일기 가져오기
	public List<Diary> getDiaryList() {
		return diaryRepository.findAll(); //모든 일기 리스트 가져오기
	}
	
	//특정 id의 일기 가져오기
	public Diary getDiary(Long id) {
		return diaryRepository.findById(id).orElse(null); 
		//해당 id의 일기가 존재하면 반환되고, 없으면 null
	}

	//특정 id의 일기 수정하기 -> update 생략가능
	
	//특정 id의 일기 삭제하기
	public void deleteDiary(Long id) {
		diaryRepository.deleteById(id);
	}
}