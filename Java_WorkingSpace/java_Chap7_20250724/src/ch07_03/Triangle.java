package ch07_03;

import java.awt.Color;

public class Triangle extends Shape {
	int width, height;
	
	public Triangle() {
		super();
	}

	public Triangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return width * height * 0.5;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public void getColor() {
		System.out.println("삼각형 색깔" + color);
	}
	
}
