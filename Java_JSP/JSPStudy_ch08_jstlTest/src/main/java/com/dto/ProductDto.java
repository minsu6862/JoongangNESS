package com.dto;

public class ProductDto {
	private String pName, pColor;
	private int pQtt;
	
	public ProductDto() {
	}
	
	public ProductDto(String pName, String pColor, int pQtt) {
		this.pName = pName;
		this.pColor = pColor;
		this.pQtt = pQtt;
	}
	
	public String getpName() {
		return pName;
	}
	
	public void setpName(String pName) {
		this.pName = pName;
	}
	
	public String getpColor() {
		return pColor;
	}
	
	public void setpColor(String pColor) {
		this.pColor = pColor;
	}
	
	public int getpQtt() {
		return pQtt;
	}
	
	public void setpQtt(int pQtt) {
		this.pQtt = pQtt;
	}
	
}
