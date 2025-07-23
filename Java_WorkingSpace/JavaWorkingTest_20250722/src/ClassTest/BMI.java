package ClassTest;

public class BMI {
	int weight, height;

	public BMI(int weight, int height) {
		this.weight = weight;
		this.height = height;
	}
	
	public void bmiCalulator() {
		double h = (double) height / 100;
		double sum = (double)weight / (h * h);
		System.out.println(String.format("%.2f", sum));
	}
}
