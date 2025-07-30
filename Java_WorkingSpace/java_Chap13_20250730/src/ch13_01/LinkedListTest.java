package ch13_01;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Board> list1 = new ArrayList<Board>();
		List<Board> list2 = new LinkedList<Board>();
		
		Date nowDate = new Date();
		
		Board board = new Board("이무진", "사랑합니다 여러분", "신곡 노래입니다", new Timestamp(nowDate.getTime()));
		
		long startTime;
		long endTime;
		
		
		startTime = System.nanoTime();
		for(int i = 0; i < 1000000; i++) {
			list1.add(board);
		}
		endTime = System.nanoTime();
		
		System.out.println(startTime);
		System.out.println(endTime);
		
		
		
		startTime = System.nanoTime();
		for(int i = 0; i < 1000000; i++) {
			list2.add(board);
		}
		endTime = System.nanoTime();
		
		System.out.println(startTime);
		System.out.println(endTime);
	}

}
