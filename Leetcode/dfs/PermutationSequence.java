package dfs;

import java.util.ArrayList;

public class PermutationSequence {

	// http://www.programcreek.com/2013/02/leetcode-permutation-sequence-java/
	public static String getPermutation(int n, int k) {
		// initialize all numbers
		ArrayList<Integer> numberList = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) 
			numberList.add(i);

		k--; // change k to be index
		int mod = 1; // set factorial of n
		for (int i = 1; i <= n; i++) {
			mod = mod * i;  // mod is the factorial now (3! = 6)
		}

		StringBuilder result = new StringBuilder();
		for (int i = 0; i < n; i++) { // find sequence
			mod = mod / (n - i);
			// find the right number(curIndex) of
			int curIndex = k / mod;

			k = k % mod; // update k
			// get number according to curIndex
			result.append(numberList.get(curIndex));
			numberList.remove(curIndex); // remove from list
		}
		return result.toString();
	}

	// public static String getPermutation(int n, int k) {
	// boolean[] visited = new boolean[n];
	// int[] factorial = new int[n];
	//
	// factorial[0] = 1;
	// for (int i = 1; i < n; i++) { // [1, 1, 2] 0! == 1, 1! == 1, 2! == 2...
	// factorial[i] = factorial[i - 1] * i;
	// }
	//
	// StringBuilder sb = new StringBuilder();
	//
	// for (int i = n - 1; i >= 0; i--) {
	// int toAppend = 1; // initialize this every time
	// while (k > factorial[i]) {
	// toAppend++;
	// k -= factorial[i];
	// }
	// for (int j = 0; j < n; j++) {
	// if (j + 1 <= toAppend && visited[j])
	// toAppend++;
	// }
	// sb.append(toAppend);
	// visited[toAppend - 1] = true;
	// }
	// return sb.toString();
	// }

	public static void main(String[] args) {
		System.out.println(getPermutation(4, 2));

	}
}
