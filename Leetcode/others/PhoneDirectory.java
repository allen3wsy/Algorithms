package others;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * Google has this (uses doubly linkedList and Map)
 * follow up: uses Trie (each level has 0 to 10...)
 * 
 * http://www.programcreek.com/2014/08/leetcode-design-phone-directory-java/
 */
public class PhoneDirectory {
	int max;
	HashSet<Integer> set;
	LinkedList<Integer> queue;

	/**
	 * Initialize your data structure here
	 * 
	 * @param maxNumbers
	 *            - The maximum numbers that can be stored in the phone
	 *            directory.
	 */
	public PhoneDirectory(int maxNumbers) {
		set = new HashSet<Integer>();
		queue = new LinkedList<Integer>();
		for (int i = 0; i < maxNumbers; i++) {
			queue.offer(i);
		}
		max = maxNumbers - 1;
	}

	/**
	 * Provide a number which is not assigned to anyone.
	 * 
	 * @return - Return an available number. Return -1 if none is available.
	 */
	public int get() {
		if (queue.isEmpty())
			return -1;

		int e = queue.poll();
		set.add(e);
		return e;
	}

	/** Check if a number is available or not. */
	public boolean check(int number) {
		// (&& number<=max) is not necessary ?! 
		return !set.contains(number);
	}

	/** Recycle or release a number. */
	public void release(int number) {
		if (set.contains(number)) {
			set.remove(number);
			queue.offer(number);
		}
	}
}
