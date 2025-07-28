package ch10_02_trycatch;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class TryCatchTest02 {

	public static void main(String[] args) {
		try {
			FileReader reader = new FileReader("abc.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
