package dfs;

import java.util.ArrayList;

public class Combinations {

	// https://leetcodenotes.wordpress.com/tag/%E5%9B%BA%E5%AE%9A%E8%A7%A3%E6%B3%95/
	// (Code)
	// http://rleetcode.blogspot.com/2014/04/combinations-java.html (Code)
	// http://blog.csdn.net/u010500263/article/details/18435495
	// (Thought and graph)
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> comb = new ArrayList<Integer>();

		if (n < k) // n should be alwasy >= k
			return result;
		dfs(n, k, result, comb, 1);
		return result;
	}

	public void dfs(int n, int k, ArrayList<ArrayList<Integer>> result,
			ArrayList<Integer> comb, int start) {
		if (comb.size() == k) {
			result.add(new ArrayList<Integer>(comb));
			return;
		}
		for (int i = start; i <= n; i++) {
			comb.add(i);
			dfs(n, k, result, comb, i + 1); // recurse from the next integer
			comb.remove(comb.size() - 1);
		}
	}
}
