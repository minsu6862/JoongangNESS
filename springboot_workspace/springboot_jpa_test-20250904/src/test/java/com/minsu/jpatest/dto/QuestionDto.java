package com.minsu.jpatest.dto;

import java.time.LocalDateTime;

import com.minsu.jpatest.entity.Questiontbl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDto {

	private int qnum;
	private String qtitle, qcontent;
	private LocalDateTime qdate, udate;
	
	public Questiontbl getEntity() {
		Questiontbl question = new Questiontbl();
		
		question.setQtitle(this.qtitle);
		question.setQcontent(this.qcontent);
		
		return question;
	}
}
