package exceptionTest;

import java.io.BufferedReader;
import java.io.FileReader;

public class ThrowsExample {
	public static void readFile() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("test.txt"));
        System.out.println(br.readLine());
        br.close();
    }
}
