package ch11_02_02;

public class ReplaceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "길동이는 순신이보다 키가 큽니다. 하지만 순신이 길동이보다 말을 잘합니다.";
		String str2 = str.replace("길동", "순신");
		
		System.out.println(str);	//replace가 원본을 수정하진 않는다.
		System.out.println(str2);
	}

}
