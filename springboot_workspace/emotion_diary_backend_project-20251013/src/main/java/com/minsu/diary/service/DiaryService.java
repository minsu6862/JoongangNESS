package com.minsu.diary.service;

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

	
}