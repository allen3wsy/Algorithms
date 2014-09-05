package others;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum {

	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates,
			int target) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		if (candidates.length == 0) {
			return results;
		}
		Arrays.sort(candidates); // have to sort first, otherwise not working
									// (not efficient)

		ArrayList<Integer> result = new ArrayList<Integer>();
		dfs(results, candidates, target, result, 0, 0);
		return results;
	}

	// at first: step == 0 which means currently looking at value cantidates[0],
	// sum is the current sum after adding current value at index [step]
	private void dfs(ArrayList<ArrayList<Integer>> results, int[] candidates,
			int target, ArrayList<Integer> result, int step, int sum) {
		if (sum == target) { // sum == target
			results.add(new ArrayList<Integer>(result)); // look at me notes!!!
															// no need to check
															// whether
			return; // results.contains(result)
		}
		if (sum > target) { // sum > target (exceed)
			return; // do nothing, return immediately
		}

		// goes to here, means: sum < target, traverse down
		for (int i = step; i < candidates.length; i++) {

			result.add(candidates[i]); // add one to result
			dfs(results, candidates, target, result, i, sum + candidates[i]);
			// Note: here pass i to level, then i is the step
			result.remove(result.size() - 1); // remove the rightmost one
		}
		return;
	}
}
