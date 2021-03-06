package dfs;

import java.util.ArrayList;
import java.util.Arrays;

public class Subsets2 {

	// think about the example: [1, 2, 2]
	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		res.add(new ArrayList<Integer>()); // the null arrayList, right now
											// res.size() == 1

		if (num == null || num.length == 0)
			return res;
		Arrays.sort(num); // sort the input Array

		int start = 0;
		for (int i = 0; i < num.length; i++) {
			int size = res.size();

			for (int j = start; j < size; j++) {
				// start: old_size, size: new_size
				ArrayList<Integer> newItem = new ArrayList<Integer>(res.get(j));
				newItem.add(num[i]);
				res.add(newItem);
			}

			if (i < num.length - 1 && num[i] == num[i + 1])
				start = size; // size is the old size
			else
				start = 0;
		}
		return res;
	}
}
