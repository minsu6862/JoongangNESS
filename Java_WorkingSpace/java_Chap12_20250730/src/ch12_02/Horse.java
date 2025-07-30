package ch12_02;

public class Horse extends Thread {
	private String horseName;

	public Horse(String horseName) {
		this.horseName = horseName;
	}
	
	@Override
	public void run() {
		int distance = 0;
		final int FINISH_LINE = 50;
		
		while (distance < FINISH_LINE) {	//결승전 통과하면 정지
			distance += (int) (Math.random() * 3) + 1;	//최소 1~3 사이 랜덤값으로 전진
			
			printHorse(horseName, distance);	//말의 이름과 위치
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(horseName + " -> 골인");
	}
	
	public void printHorse(String horseName, int position) {	//말의 위치를 출력하는 메소드
		System.out.println(horseName + " : " + position);
	}
}
