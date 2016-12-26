package test;

import java.util.*;

// 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110 = d(220) = 284. 
// 1, 2, 4, 71, 142; so d(284) = 220.

// (220, 284)
// d(2) == 1,
// d(3) == 1,
// d(4) == 3,
// d(5) == 1, 
// d(6) == 6,
// d(7) == 1.

/**
 * @author Allen's correct version after correcting from @Leon's old version.
 *         (But I am not sure if I could optimize it... now it's O(N) time)
 */
public class AmicableNumbers {
	public static void main(String[] args) {
		List<int[]> list = amicable(10000);
		for (int i = 0; i < list.size(); i++) {
			int[] pair = list.get(i);
			System.out.println("" + pair[0] + " ," + pair[1]);
		}
	}

	public static List<int[]> amicable(int n) {

		List<int[]> list = new ArrayList<int[]>();

		if (n == 1) { // base case
			int[] result = { 1, 1 };
			list.add(result);
			return list;
		}

		// normal case
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		// This has to go to n, (e.g. when n == 285, i has to go through 220 and
		// 284)
		for (int i = 2; i <= n; i++) {
			int curSumOfD = 0;
			if (map.containsKey(i)) {
				if (map.get(i) == sumOfD(i)) {
					int[] pair = { map.get(i), i };
					list.add(pair);
				}
			} else {
				curSumOfD = sumOfD(i);
				map.put(curSumOfD, i);
			}
		}
		return list;
	}

	// It shouldn't include itself...
	public static int sumOfD(int n) {
		int sum = 0;
		for (int i = 1; i <= n / 2; i++) {
			if (n % i == 0) {
				sum += i;
			}
		}
		return sum;
	}
}