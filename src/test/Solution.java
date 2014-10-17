package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Solution {
	private static final String TO = "to";
	private static final String EMPTY = "empty";
	private static final String LOOP = "loop";
	private static final String NULL = "null";
	private static final String INCREASING = "increasing";
	private static final int MAX = 10000;

	public static void main(String args[]) throws Exception {
		try (Scanner in = new Scanner(System.in)) {
			args = in.nextLine().split(" ");
			List<Iterator<String>> lists = generateIterators(args);
			Iterator<Iterator<String>> iters = lists.iterator();
			Iterator<String> flattened = flatten(iters);
			int counter = 0;
			while (flattened.hasNext() && ++counter < MAX) {
				System.out.println(flattened.next());
			}
		}
	}

	// crazy hack to generate the iterators
	private static List<Iterator<String>> generateIterators(String[] args) {
		List<Iterator<String>> topLvlList = new ArrayList<>();
		String[] stringLists = args[1].split("#");
		if (args[0].equals("list")) {
			for (String stringList : stringLists) {
				String[] split = stringList.split("%");
				if (split.length == 1 && split[0].isEmpty()) {
					split = new String[0];
				}
				topLvlList.add(Arrays.asList(split).iterator());
			}
		} else if (args[0].equals("function")) {
			for (String function : stringLists) {
				if (function.startsWith(INCREASING)) {
					final String[] numbers = function.substring(
							INCREASING.length()).split(TO);
					topLvlList.add(new Iterator<String>() {
						int min = Integer.parseInt(numbers[0]);
						int max = Integer.parseInt(numbers[1]);

						public boolean hasNext() {
							return min < max;
						}

						public String next() {
							return String.valueOf(min++);
						}

						public void remove() {
							throw new UnsupportedOperationException();
						}
					});
				} else if (function.startsWith(LOOP)) {
					final String[] numbers = function.substring(LOOP.length())
							.split(TO);
					topLvlList.add(new Iterator<String>() {
						int min = Integer.parseInt(numbers[0]);
						int max = Integer.parseInt(numbers[1]);
						int x = min;

						public boolean hasNext() {
							return true;
						}

						public String next() {
							String output = String.valueOf(x);
							x++;
							if (x >= max) {
								x = min;
							}
							return output;
						}

						public void remove() {
							throw new UnsupportedOperationException();
						}
					});
				} else if (function.startsWith(NULL)) {
					topLvlList.add(null);
				} else if (function.startsWith(EMPTY)) {
					topLvlList.add(new Iterator<String>() {
						public boolean hasNext() {
							return false;
						}

						public String next() {
							throw new NoSuchElementException();
						}

						public void remove() {
							throw new UnsupportedOperationException();
						}
					});
				}
			}
		}
		return topLvlList;
	}

	static class FlattenIterator implements Iterator<String> {
		Iterator<Iterator<String>> iters;
		Iterator<String> cur;

		public FlattenIterator(Iterator<Iterator<String>> itr) {
			iters = itr;
			try {
				while (cur == null) {
					cur = iters.next();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		public boolean hasNext() {
			return cur.hasNext();
		}

		public String next() {
			String nextString = cur.next();
			while (!cur.hasNext()) {
				if(iters.hasNext())
					cur = iters.next();
				else 
					break;
			}
			return nextString;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

	}

	public static Iterator<String> flatten(Iterator<Iterator<String>> iters) {
		return iters.hasNext() ? new FlattenIterator(iters) : null;
	}
}