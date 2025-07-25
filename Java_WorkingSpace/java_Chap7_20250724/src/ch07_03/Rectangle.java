package ch07_03;

public class Rectangle extends Shape{
int width, height;
	
	public Rectangle() {
		super();
	}

	public Rectangle (int width, int height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return width * height;
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
		System.out.println("사각형 색깔" + color);
		
	}
}
