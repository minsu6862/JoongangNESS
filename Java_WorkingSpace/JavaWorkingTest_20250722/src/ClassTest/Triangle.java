package ClassTest;

public class Triangle {
	int a, b, c;

	public Triangle(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public boolean isValid() {
        if (a <= 0 || b <= 0 || c <= 0) {
            return false;
        }
        
        return (a + b > c) && (a + c > b) && (b + c > a);
    }
	
	public void Check() {
		if (isValid()) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}
}
