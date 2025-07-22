package ch05_03;

public class enumTest04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Size cloth = Size.XXXL;
		
		switch (cloth) {
		case SM :
			System.out.println("선택하신 사이즈는 SM입니다");
			break;
		case L :
			System.out.println("선택하신 사이즈는 L입니다");
			break;
		case XL :
			System.out.println("선택하신 사이즈는 XL입니다");
			break;
		case XXL :
			System.out.println("선택하신 사이즈는 XXL입니다");
			break;
		case XXXL :
			System.out.println("선택하신 사이즈는 XXXL입니다");
			break;
		}
	}

}
