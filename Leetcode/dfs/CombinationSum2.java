package dfs;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum2 {

	public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		if (num.length == 0) {
			return results;
		}
		Arrays.sort(num); // have to sort first, otherwise not working (not
							// efficient)
		ArrayList<Integer> result = new ArrayList<Integer>();
		dfs(results, num, target, result, 0, 0);
		return results;
	}

	// at first: step == 0 which means currently looking at value cantidates[0],
	// sum is the current sum after adding current value at index [step]
	private void dfs(ArrayList<ArrayList<Integer>> results, int[] candidates,
			int target, ArrayList<Integer> result, int step, int sum) {
		if (sum == target) { // sum == target
			if (!results.contains(result)) {
				// this is not the best way to do it. use a while loop to skip
				// it would be better
				results.add(new ArrayList<Integer>(result));
				// look at my notes!!! NEED to check whether
			} // results.contains(result)
			return;
		}

		if (sum > target) { // sum > target (exceed)
			return; // do nothing, return immediately
		}

		// goes to here, means: sum < target, traverse down
		for (int i = step; i < candidates.length; i++) {
			result.add(candidates[i]); // add one to result
			dfs(results, candidates, target, result, i + 1, sum + candidates[i]);
			// Note: here pass i + 1 to next level, then i + 1 is the step
			result.remove(result.size() - 1); // remove the rightmost one
		}
		return;
	}
}
