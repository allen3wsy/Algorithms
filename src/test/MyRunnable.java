package test;

import java.util.List;

// pay attention here!!!
// Yahoo onsite interview
public class MyRunnable implements Runnable {

	String myString = "Yes ";

	public void run() {
		this.myString = "No ";
	}

	public static void main(String[] args) throws InterruptedException {
		MyRunnable t = new MyRunnable(); // object that implements Runnable

		synchronized (t) {
			new Thread(t).start();
//			Thread.sleep(100); // if not added, result would be different
			// because new Thread(t) will take sometime to new

			for (int i = 0; i < 10; i++)
				System.out.print(t.myString);
		}
	}
}