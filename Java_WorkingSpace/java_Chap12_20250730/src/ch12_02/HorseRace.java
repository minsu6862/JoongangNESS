package ch12_02;

public class HorseRace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Horse horse1 = new Horse("멘헤튼 카페");
		Horse horse2 = new Horse("그레이드");
		Horse horse3 = new Horse("딥 임펙트");
		Horse horse4 = new Horse("골드쉽");
		
		System.out.println("========================");
		horse1.start();
		horse2.start();
		horse3.start();
		horse4.start();
	}

}
