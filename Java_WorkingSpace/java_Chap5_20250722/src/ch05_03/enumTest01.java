package ch05_03;

public class enumTest01 {
	
	enum Gender {
		MALE,
		FEMALE
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gender m = Gender.MALE;
		Gender f = Gender.FEMALE;
		
		if(m == Gender.MALE) {
			System.out.println("남성입니다.");
		} else {
			System.out.println("여성입니다.");
		}
		
		//enum을 쓰는 이유 1. 가독성, 2. 정해진 값에만 접근이 필요한 경우(ex. 성별, 요일 등)
	}

}
