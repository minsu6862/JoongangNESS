package ch07_01;

public class Dogs extends Animal {
	String dogtail;
	
	public Dogs() {
		super();		//부모 클래스의 생성자 호출
	}
	
	public Dogs(String dogtail) {
		this.dogtail = dogtail;
	}

	public Dogs(String dogtail, String name) {
		super();	
		this.dogtail = dogtail;
	}
	public void dogSpeed() {
		System.out.println("강아지의 평균 달리기 속도는 시속 15km입니다.");
	}
}
