package two_Dimensional_DP;

import java.util.ArrayList;

/**
 * @author AllenNg
 */
// Brute force algo is O(2^N)
// THIS algo is O(N^2)： O(N^2) space as well
// can be improved to O(N log N) : using binary search for each List !!!
public class LongestIncreasinSubstring {

	public static ArrayList<ArrayList<Integer>> LIS(int[] arr) {
		// all the lists (we just need the longest one)
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < arr.length; i++)
			result.add(new ArrayList<Integer>());

		result.get(0).add(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) { // j is always < i
				// arr[j] <= arr[i] here means monotonically
				if (arr[j] <= arr[i] && (result.get(j).size() >= result.get(i).size())) {
					// copy list(j) to list(i)
					ArrayList<Integer> temp = new ArrayList<Integer>(result.get(j));
					result.set(i, temp);
				}
			}
			// list(i) should always contain arr[i]
			result.get(i).add(arr[i]);
		}
		return result;
	}

	// monotonously increasing
	public static void main(String[] args) {
		int[] array1 = { 1, 2, 4, 7, 6, 8 };
		System.out.println(LIS(array1));

		int[] array2 = { 3, 2, 6, 4, 5, 1};
		System.out.println(LIS(array2));
	}
}
