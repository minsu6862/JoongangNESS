package ClassExam;

public class Score {
	int kor, eng, math;

	public Score(int kor, int eng, int math) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	public void printScore() {
		int sum = kor + eng + math;
		double avg = (double) (kor + eng + math) / 3;
		
		System.out.println("총점 : " + sum);
		System.out.println("평균 : " + avg);
		if (avg >= 90) {
			System.out.println("우수");
		} else if( avg < 60) {
			System.out.println("재시험");
		} else {
			System.out.println("보통");
		}
	}
	
}
