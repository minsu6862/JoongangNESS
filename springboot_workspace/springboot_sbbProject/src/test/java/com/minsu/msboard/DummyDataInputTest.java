package com.minsu.msboard;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.minsu.msboard.question.QuestionService;

@SpringBootTest
public class DummyDataInputTest {

	@Autowired
	private QuestionService questionService;
	
	@Test
	public void testDummy() {
		for(int i=0; i<=300; i++) {
			questionService.create(i + "번째 질문글입니다", i + "번째 테스트 데이터입니다.", null);
		}
		
	}
}
