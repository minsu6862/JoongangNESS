package ClassTest;

public class Rectangle {
	double width, height;

	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	public Rectangle(double width, int height) {
		this.width = width;
		this.height = height;
	}

	public Rectangle(int width, double height) {
		this.width = width;
		this.height = height;
	}
	
	public void Calc() {
		double sum = ( 2 * width ) + ( 2 * height );
		System.out.println(sum);
	}
}
