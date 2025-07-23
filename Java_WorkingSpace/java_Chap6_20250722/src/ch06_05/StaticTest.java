package ch06_05;

public class StaticTest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		human man1 = new human();
		man1.width = 10;
		man1.height = 20;
		man1.color = "red";
		
		human man2 = new human();
		man2.width = 50;
		man2.height = 60;
		man2.color = "blue";
		
		
	}

}
	

class human {
	static final double PI = 3.14;	//정적 멤버 변수, 일반적으로 만들 경우 man1과 man2에 각각 pi가 만들어지기에
	int width;							//데이터가 중복되는것을 막기 위해 static으로 사용하여 한개의 데이터에 각각 접근하는식으로 설계
	int height;
	String color;
}