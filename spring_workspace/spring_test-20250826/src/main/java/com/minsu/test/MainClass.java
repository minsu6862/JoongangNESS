package com.minsu.test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//MyCalculator myCalculator = new MyCalculator();
		//myCalculator.setA(10);
		//myCalculator.setB(5);
//		Calculator calculator = new Calculator();
//		Calculator calculator2 = new Calculator();
//		Calculator calculator3 = new Calculator();
		
		//myCalculator.setCalculator(calculator);
		
		//멤버변수(멤버객체)인 calculator 외부에서 객체를 생성하여 초기화->DI
		
		//myCalculator.addition();
		
		//MyCalculator myCalculator2 = new MyCalculator(calculator);
		//myCalculator2.divsion();
		
		String configLocation = "classpath:applicationCTX.xml";
		//스프링 컨테이너인 applicationCTX.xml을 로드하라
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		//ctx 라는 이름으로 컨테이너 생성
		
		MyCalc myCalculator = ctx.getBean("myCalc", MyCalc.class);
		//스프링 컨테이너에서 객체를 가져온거->DI
		
		myCalculator.addition();
		
		
		
	}

}
