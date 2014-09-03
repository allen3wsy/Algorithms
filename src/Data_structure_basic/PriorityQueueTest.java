package Data_structure_basic;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueTest {

	static class PQmax implements Comparator<Integer> {

		public int compare(Integer one, Integer two) {
			return two - one;
		}
	}

	public static void main(String[] args) {
		int[] ia = {1, 10, 5, 3, 4, 7, 6, 9, 8};
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

		// use offer() method to add elements to the PriorityQueue pq1
		for (int x : ia) {
			minHeap.offer(x);
		}

		System.out.println("pq1: " + minHeap);

		PQmax max = new PQmax();
		
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(10, max);
		// In this particular case, we can simply use Collections.reverseOrder()
		// instead of self-defined comparator
		for (int x : ia) {
			maxHeap.offer(x);
		}

		System.out.println("pq2: " + maxHeap);

		// print size
		System.out.println("size: " + maxHeap.size());
		// return highest priority element in the queue without removing it
		System.out.println("peek: " + maxHeap.peek());
		// print size
		System.out.println("size: " + maxHeap.size());
		// return highest priority element and removes it from the queue
		System.out.println("poll: " + maxHeap.poll());
		// print size
		System.out.println("size: " + maxHeap.size());

		System.out.print("pq2: " + maxHeap);
	}

	
	public void inputtoheap(int input) {
		// add to the right heap
		// if heap size difference >2, re-arrange
		// outptut the medium6

	}

}