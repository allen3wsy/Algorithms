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
	
	static class Wrapper {
		static int num;

		public Wrapper(int n) {
			num = n;
		}

		synchronized void hello() throws InterruptedException {
			if (num < 49) {
				num++;
				this.wait();
			}

			if (num == 49)
				this.notifyAll();
		}
	}

	public static void main(String[] args) {
		AllenThread allenThread = new AllenThread(0);
		allenThread.start();
		// allenThread.run(); // which runs on the main thread

		Leon l = new Leon();
		// l.start(); // implements Runnable is like a running a task
		l.run();

		/**
		 * create 50 threads at the same time !!!
		 */
		final Wrapper wrapper = new Wrapper(0);

		Runnable task = new Runnable() {

			@Override
			public void run() {
				try {
					wrapper.hello();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				System.out.println(System.currentTimeMillis());
			}
		};

		for (int i = 0; i < 50; i++) {
			new Thread(task).start();
		}
	}
}

class Leon implements Runnable {

	@Override
	public void run() {
		System.out.println("Leon runnable");
	}
}
