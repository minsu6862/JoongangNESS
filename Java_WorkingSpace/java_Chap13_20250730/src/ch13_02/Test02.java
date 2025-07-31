package ch13_02;

import java.util.HashMap;
import java.util.Map;

public class Test02 {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("blue", 96);
		map.put("hong", 86);
		map.put("white", 92);
		String name = null;
		int maxScore = 0;
		int totalScore = 0;
		
		for(String key : map.keySet()) {
			int score = map.get(key);
			totalScore += score;
			if (score > maxScore) {
				maxScore = score;
				name = key;
			}
		}
		
		System.out.println("평균 점수 : " + (totalScore / map.size()));
		System.out.println("최고 점수 : " + maxScore);
		System.out.println("최고 점수를 받은 아이디 : " + name);
	}

}
