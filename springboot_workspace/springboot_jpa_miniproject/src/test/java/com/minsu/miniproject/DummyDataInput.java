package com.minsu.miniproject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.minsu.miniproject.board.BoardService;

import lombok.experimental.PackagePrivate;

@SpringBootTest
public class DummyDataInput {

	@Autowired
	@PackagePrivate BoardService boardService;
	
	@Test
	public void testDummy() {
		
		for(int i=0; i<=200; i++) {
			boardService.write(i+"번째 글입니다.", "테스트 글 내용입니다", null);
		}
	}
}
