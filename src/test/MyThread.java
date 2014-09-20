package test;

// pay attention here!!!
// Yahoo onsite interview
public class MyThread implements Runnable {

	String myString = "Yes ";

	public void run() {
		this.myString = "No ";
	}

	public static void main(String[] args) throws InterruptedException {
		MyThread t = new MyThread();
		synchronized (t) {

			new Thread(t).start();
			// Thread.sleep(100); // if not added, result would be different

			for (int i = 0; i < 10; i++)
				System.out.print(t.myString);
		}
	}
}