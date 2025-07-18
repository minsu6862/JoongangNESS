package ch04_01;

public class ifTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int score = 60;
		
		System.out.print("귀하의 성적은 ");
		if (score >= 90) {
			System.out.print("수");
		} else if(score >=80) {
			System.out.print("우");
		} else if(score >=70) {
			System.out.print("미");
		} else if(score >=60) {
			System.out.print("양");
		} else {
			System.out.print("가");
		}
		
		System.out.println("입니다.");
		
		//value값이 10이상 20미만이면 통과를 출력하시오
		
		int value = 15;
		
		if ( value >= 10 && value < 20) {
			System.out.println("통과");
		} else {
			System.out.println("실패");
		}
	}

}
