package interviewFLGT;

import java.util.LinkedList;
import java.util.Queue;

// http://tutorials.jenkov.com/java-concurrency/blocking-queues.html
public class BlockingQueueTest {

	private Queue<Integer> queue = new LinkedList<Integer>();
	private int capacity = 10;

	public BlockingQueueTest(int limit) {
		this.capacity = limit;
	}

	public synchronized void enqueue(int item) throws InterruptedException {
		// here we also have to use while !!!
		while (this.queue.size() == this.capacity) {
			this.wait();
		}
		if (this.queue.size() == 0) {
			this.notifyAll(); // note we have to notifyAll() here !!!
		}
		this.queue.add(item); // can also put this before notifyAll()
	}

	// both methods have to use synchronized
	public synchronized int dequeue() throws InterruptedException {
		// here we use
		while (this.queue.size() == 0) {
			System.out.println("Thread ID: " + Thread.currentThread().getId()
					+ " is waiting");
			this.wait();
			System.out.println("Thread ID: " + Thread.currentThread().getId()
					+ " was just notified");
		}
		if (this.queue.size() == this.capacity) {
			this.notifyAll(); // note we have to notifyAll() here !!!
		}
		System.out.println("dequeuing successfully! "
				+ Thread.currentThread().getId() + "  size left:"
				+ (queue.size() - 1));
		return this.queue.poll(); // can also put this before notifyAll()
	}

	public static void main(String[] args) {
		BlockingQueueTest blockingQueue = new BlockingQueueTest(3);
		
		Runnable enqueueTask = new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						blockingQueue.enqueue(1);
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		Runnable dequeueTask = new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						blockingQueue.dequeue();
						Thread.sleep(1000);
						System.out.println("Thread ID: "
								+ Thread.currentThread().getId()
								+ " SLEEP !!!! ");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		// start the 2 threads
		new Thread(enqueueTask).start();
		new Thread(dequeueTask).start();
	}
}
