package com.dto;

public class BoardDto {
	private int bnum;	//게시글 번호, 작성자, 날짜
	private String btitle, bwriter, bdate;	//게시글 제목
	//private String bcontent;	게시글 내용
	
	public BoardDto() {
	}

	public BoardDto(int bnum, String btitle, String bwriter, String bdate) {
		this.bnum = bnum;
		this.btitle = btitle;
		this.bwriter = bwriter;
		this.bdate = bdate;
	}

	public int getBnum() {
		return bnum;
	}

	public void setBnum(int bnum) {
		this.bnum = bnum;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBwriter() {
		return bwriter;
	}

	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	
	
}
