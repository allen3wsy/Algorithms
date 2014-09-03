package interviewFLGT;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class FindMedian {
	
	public static void printMedian(int i, PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
		
		if(maxHeap.size() == 0 && minHeap.size() == 0) {
			maxHeap.offer(i);
		} else if(i > maxHeap.peek()) {		// maxHeap.size() ALWAYS >= 0 
			minHeap.offer(i);
		} else {
			maxHeap.offer(i);
		}
		
		// balancing the sizes of the 2 heaps
		if(maxHeap.size() - minHeap.size() >= 2) {
			minHeap.offer(maxHeap.poll());
		} else if (minHeap.size() - maxHeap.size() >= 2) {
			maxHeap.offer(minHeap.poll());
		}
		
		// print the medians (1 or 2)
		if(maxHeap.size() == minHeap.size())	{
			System.out.println("Two medians: " + maxHeap.peek() + " and " + minHeap.peek());
		} else if(maxHeap.size() > minHeap.size()) {
			System.out.println("Median is " + maxHeap.peek());
		} else {
			System.out.println("Median is " + minHeap.peek());
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		Comparator<Integer> descendingComparator = new Comparator<Integer>() {
			public int compare(Integer i1, Integer i2) {
				return i2 - i1;
			}
		};
		
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(1, descendingComparator);
		
		while(true) {
			System.out.println("please input an Integer: ");
			printMedian(scanner.nextInt(), minHeap, maxHeap);
		}
	}
}