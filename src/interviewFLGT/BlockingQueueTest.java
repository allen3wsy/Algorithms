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
			wait();
		}
		if (this.queue.size() == 0) {
			notifyAll(); // note we have to notifyAll() here !!!
		}
		this.queue.add(item); // can also put this before notifyAll()
	}

	// both methods have to use synchronized
	public synchronized int dequeue() throws InterruptedException {
		// here we use
		while (this.queue.size() == 0) {
			wait();
		}
		if (this.queue.size() == this.capacity) {
			notifyAll(); // note we have to notifyAll() here !!!
		}
		return this.queue.poll(); // can also put this before notifyAll()
	}
}
