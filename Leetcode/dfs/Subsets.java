package dfs;

import java.util.ArrayList;
import java.util.Arrays;

public class Subsets {

	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
		if (S == null)
			return null;

		Arrays.sort(S);
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < S.length; i++) {
			ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
			// get sets already in result and copy all of them to temp
			for (ArrayList<Integer> a : result) {
				temp.add(new ArrayList<Integer>(a));
			}
			// add S[i] to existing sets
			for (ArrayList<Integer> a : temp) {
				a.add(S[i]);
			}
			// add S[i] only as a set
			temp.add(new ArrayList<Integer>(Arrays.asList(S[i])));

			result.addAll(temp); // append all the ArrayLists in temp to result!
		}
		// add empty set
		result.add(new ArrayList<Integer>());
		return result;
	}

	public static void main(String[] args) {

	}
}
