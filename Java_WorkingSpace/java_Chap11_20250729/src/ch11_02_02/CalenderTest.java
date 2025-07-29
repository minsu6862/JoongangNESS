package ch11_02_02;

import java.util.Calendar;

public class CalenderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar calNow = Calendar.getInstance();
		
		int year = calNow.get(Calendar.YEAR);
		int month = calNow.get(Calendar.MONTH) + 1;
		int day = calNow.get(Calendar.DAY_OF_MONTH);
		
		int hour = calNow.get(Calendar.HOUR_OF_DAY);
		int minute = calNow.get(Calendar.MINUTE);
		int second = calNow.get(Calendar.SECOND);
		
		System.out.println(year + "년 " + month + "월 " + day + "일");
		System.out.println(hour + "시 " + minute + "분 " + second + "초");
		
		int weekday = calNow.get(Calendar.DAY_OF_WEEK);
		
		switch (weekday) {
        case Calendar.SUNDAY: // 1
            System.out.println("오늘의 요일은 일요일입니다.");
            break;
        case Calendar.MONDAY: // 2
            System.out.println("오늘의 요일은 월요일입니다.");
            break;
        case Calendar.TUESDAY: // 3
            System.out.println("오늘의 요일은 화요일입니다.");
            break;
        case Calendar.WEDNESDAY: // 4
            System.out.println("오늘의 요일은 수요일입니다.");
            break;
        case Calendar.THURSDAY: // 5
            System.out.println("오늘의 요일은 목요일입니다.");
            break;
        case Calendar.FRIDAY: // 6
            System.out.println("오늘의 요일은 금요일입니다.");
            break;
        case Calendar.SATURDAY: // 7
            System.out.println("오늘의 요일은 토요일입니다.");
            break;
		}
	}

}
