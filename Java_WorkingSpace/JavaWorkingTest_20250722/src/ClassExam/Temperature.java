package ClassExam;

public class Temperature {
	double celsius;
	
	public Temperature(double celsius) {
		this.celsius = celsius;
	}

	public double toFahrenheit() {
		return (celsius * 1.8) + 32;
	}
}
