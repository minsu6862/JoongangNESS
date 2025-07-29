package ch11_02_02;

public class MathTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Math.abs(-10));	//절대값 계산
		
		System.out.println(Math.ceil(3.14));	//소수점 올림
		System.out.println(Math.floor(3.14));	//소수점 내림
		System.out.println(Math.round(3.14));	//소수점 반올림
		
		System.out.println(Math.max(5, 10));	//둘 중 큰 값 리턴
		System.out.println(Math.min(5, 10));	//둘 중 작은 값 리턴
		
		System.out.println(Math.random() * 10 + 1);
		
		System.out.println(Math.rint(5));	//인수값에 제일 가까운 정수를 실수로 리턴
	}
}
