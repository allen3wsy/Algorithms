package test;

import java.util.concurrent.CountDownLatch;

public class Sleepsort {

	public static void sleepSortAndPrint(int[] nums) {
		final CountDownLatch doneSignal = new CountDownLatch(nums.length);

		for (final int num : nums) {
			new Thread(new Runnable() {
				public void run() {
					doneSignal.countDown();
					try {
						doneSignal.await();
						// using straight milliseconds produces unpredictable
						// results with small numbers
						// using 1000 here gives a nifty demonstration
						Thread.sleep(num * 1000);
						System.out.println(num);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
	}

	public static void main(String[] args) {
		int[] nums = { 3, 1, 4, 5, 2, 3, 1, 6, 1, 3, 2, 5, 4, 6 };
		sleepSortAndPrint(nums);
	}
}