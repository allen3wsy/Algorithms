package dfs;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum2 {

	public static ArrayList<ArrayList<Integer>> combinationSum2(int[] num,
			int target) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length == 0)
			return results;
		Arrays.sort(num); // have to sort first, otherwise not working
		ArrayList<Integer> result = new ArrayList<Integer>();
		dfs(results, num, target, result, 0, 0);
		return results;
	}

	// at first: step == 0 which means currently looking at value cantidates[0],
	// sum is the current sum after adding current value at index [step]
	private static void dfs(ArrayList<ArrayList<Integer>> results,
			int[] candidates, int target, ArrayList<Integer> result, int step,
			int sum) {
		if (sum == target) { // sum == target
			results.add(new ArrayList<Integer>(result));
			return;
		}

		if (sum > target) { // sum > target (exceed)
			return; // do nothing, return immediately
		}

		// goes to here, means: sum < target, traverse down
		for (int i = step; i < candidates.length; i++) {
			if (i != step && candidates[i] == candidates[i - 1])
				continue; // skip the duplicates !!!

			result.add(candidates[i]); // add one to result
			dfs(results, candidates, target, result, i + 1, sum + candidates[i]);
			// Note: here pass i + 1 to next level, then i + 1 is the step
			result.remove(result.size() - 1); // remove the rightmost one
		}
		return;
	}

	public static void main(String[] args) {
		int[] num = { 1, 2, 2, 3, 3 };
		// no duplicates
		System.out.println(combinationSum2(num, 6));
	}
}
