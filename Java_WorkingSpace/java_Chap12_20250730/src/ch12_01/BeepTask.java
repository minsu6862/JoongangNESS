package ch12_01;

public class BeepTask implements Runnable {
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println("띵!");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
