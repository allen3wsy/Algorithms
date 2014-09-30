package test;

class AllenThread extends Thread {
	long minPrime;

	AllenThread(long minPrime) {
		this.minPrime = minPrime;
		System.out.println(this.minPrime);
	}

	public void run() {
		System.out.print("Allen Run ");
		System.out.println(Thread.currentThread().getId());
	}

	public static void main(String[] args) {
		AllenThread allenThread = new AllenThread(0);
		allenThread.start();
		// allenThread.run(); // which runs on the main thread

		Leon l = new Leon();
		// l.start(); // implements Runnable is like a running a task
		l.run();
	}
}

class Leon implements Runnable {

	@Override
	public void run() {
		System.out.println("Leon runnable");
	}
}
