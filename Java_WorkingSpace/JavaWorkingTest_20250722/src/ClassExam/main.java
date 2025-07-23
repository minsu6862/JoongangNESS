package ClassExam;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1번
		Product p = new Product(5000, 30);
		System.out.println("1번 총 가격 : " + p.getTotalPrice());
		
		//2번
		Score s = new Score(60, 70, 80);
		s.printScore();
		
		//3번
		Temperature t = new Temperature(30);
		double temp = t.toFahrenheit();
		System.out.println("화씨 온도 : " + temp);
		
		//4번
		Movie m = new Movie("홍길동전", 123);
		boolean run = m.isLongMovie();
		System.out.println("긴 영화인가요? " + run);
	}

}
