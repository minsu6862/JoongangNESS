package ClassTest;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1번
		Book b = new Book("난쟁이가 쏘아올린 공", 13000);
		b.printInfo();
		
		//2번
		StringTool st = new StringTool("난쟁이가 쏘아올린 공");
		st.printLength();
		
		//3번
		AverageCalculator a = new AverageCalculator(new int[] {10, 20, 30, 40});
		a.getAverage();
		
		//4번
		BMI bmi = new BMI(80, 180);
		bmi.bmiCalulator();
		
		//5번
		Rectangle r = new Rectangle(5, 7.5);
		r.Calc();
		
		//6번
		Triangle t = new Triangle(3, 4, 5);
		t.Check();
	}
}

