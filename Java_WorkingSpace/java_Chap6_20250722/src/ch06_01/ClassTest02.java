package ch06_01;

public class ClassTest02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		School stu1 = new School();
		stu1.name = "홍길동";
		stu1.stuNum = "20250722";
		stu1.age = 22;
		stu1.phone = "01012345678";
		stu1.address = "서울시 종로구";
		stu1.output();
		
		School stu2 = new School();
		stu2.name = "김유신";
		stu2.stuNum = "20240311";
		stu2.age = 25;
		stu2.phone = "01056781234";
		stu2.address = "서울시 구로구";
		stu2.output();
	}

}

class School {
	String name;
	String stuNum;
	int age;
	String phone;
	String address;
	
	//String name, String stuNum, int age, String phone, String address
	public School () {
		
	}
	public School (String name, String stuNum, int age, String phone, String address) {
		this.name = name;
		this.stuNum = stuNum;
		this.age = age;
		this.phone = phone;
		this.address = address;
	}
	
	public void output() {
		System.out.println(name);
	}
	
}