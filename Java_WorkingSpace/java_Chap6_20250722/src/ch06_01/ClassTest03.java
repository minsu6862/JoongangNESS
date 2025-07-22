package ch06_01;

public class ClassTest03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Triangle a = new Triangle(5, 7, 4);	//객체 생성 -> 인스턴스 선언
		
		double sum = a.tri();
		System.out.println(sum);
		
		int length = a.length();
		System.out.println(length);
	}

}

class Triangle {
	int height;
	int width;
	int length;
	
	public Triangle(int height, int width, int length) {
		this.height = height;
		this.width = width;
		this.length = length;
	}
	
	public double tri () {
		double sum =((double) height * width) / 2;
		
		return sum;
	}
	
	public int length() {
		return length;
	}
}