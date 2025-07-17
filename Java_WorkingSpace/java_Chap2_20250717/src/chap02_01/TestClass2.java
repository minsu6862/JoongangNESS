package chap02_01;

public class TestClass2 {
	public static void main(String[] args) {
		int hour = 3;
		int minute = 5;
		
		System.out.println(hour + "시간 " + minute + "분 입니다.");
		
		int totalMinute = (hour * 60) + minute;
		System.out.println("전체 시간은 " + totalMinute + " 입니다.");
		
	}
}
