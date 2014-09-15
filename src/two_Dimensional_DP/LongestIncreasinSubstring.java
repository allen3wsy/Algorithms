package two_Dimensional_DP;

import java.util.ArrayList;

// not yet !!

public class LongestIncreasinSubstring {

	/*
	 * longest increasing substring O(N squared) but there is a O(N lg N)
	 * solution, which can't print out the LISubsequence (just the length)
	 */
	public static ArrayList<ArrayList<Integer>> LIS(int[] arr) {

		// all the lists (we just need the longest one)
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < arr.length; i++)
			result.add(new ArrayList<Integer>());

		result.get(0).add(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {

				// D[j] <= D[i] here means monotonically
				if (arr[j] <= arr[i]
						&& (result.get(j).size() >= result.get(i).size())) {
					ArrayList<Integer> list = new ArrayList<Integer>();
					list.addAll(result.get(j)); // instead assigning L.get(j) to
												// list, we use addAll to avoid
												// referencing the same list
					result.set(i, list); // cover the previous list
				}
			}
			// this element should always be added, this cannot be avoided
			result.get(i).add(arr[i]);
		}
		return result;
	}

	// monotonously increasing
	public static void main(String[] args) {
		int[] array = { 1, 2, 4, 7, 6, 8 };
		System.out.println(LIS(array));
		
	}
}
