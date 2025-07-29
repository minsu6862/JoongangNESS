package ch11_02_02;

import java.io.UnsupportedEncodingException;

public class EncodingTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "안녕하세요";
		
		byte[] bytes1 = str.getBytes();
		System.out.println(bytes1);
		System.out.println(bytes1.length);
		
		String str2 = new String(bytes1);
		System.out.println(str2);
		
		try {
			byte[] bytes2 = str.getBytes("EUC-KR");
			System.out.println(bytes2.length);
			byte[] bytes3 = str.getBytes("UTF-8");
			System.out.println(bytes3.length);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
