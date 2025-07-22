package ch05_03;

public class enumTest03 {

	enum Season {
		SPRING, SUMMER, FALL, WINTER
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Season nowTime = Season.SUMMER;
		
		switch (nowTime) {
		case SPRING :
			System.out.println("꽃이 피는 봄입니다.");
			break;
		case SUMMER :
			System.out.println("찌는듯이 더운 여름입니다.");
			break;
		case FALL :
			System.out.println("단풍이 드는 가을입니다.");
			break;
		case WINTER :
			System.out.println("눈이 오는 겨울입니다.");
			break;
		}
	}

}
