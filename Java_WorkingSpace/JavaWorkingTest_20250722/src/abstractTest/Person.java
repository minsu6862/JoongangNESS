package abstractTest;

public abstract class Person {
	String name;
	
    Person(String name) {
        this.name = name;
    }
    
    abstract void sayHello();
    
    public static void printHi() {
    	System.out.println("안녕하세요. 반갑습니다!");
    }
}
