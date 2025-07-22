package ClassExam;

public class Movie {
	String title, genre;
	int runtime;
	
	public Movie(String title, int runtime) {
		this.title = title;
		this.runtime = runtime;
	}
	
	public boolean isLongMovie() {
		if(runtime >= 120) {
			return true;
		} else {
			return false;
		}
	}
}
