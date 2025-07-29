package ch11_02_02;

public class IndexOfTest {

	public static void main(String[] args) {
		String str = "대한민국 일본";
		
		int index = str.indexOf("일본");
		System.out.println(index);
		
		if(str.indexOf("민국") == -1) {	//	일치되는 문자열을 찾지 못하면 -1 리턴
			System.out.println("민국이 포함되어 있습니다");
		} else {
			System.out.println("민국이 포함되지 않습니다.");
		}
		
		System.out.println(str.length());
	}

}
