package ch05_03;

public class enumTest02 {
	
	enum Day {
		MONDAY,
		THESDAY,
		WEDNESDAY,
		THURSDAY,
		FRIDAY,
		SATURDAY,
		SUNDAY
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Day today = Day.THESDAY;
		
		System.out.println(today);
	}

}
