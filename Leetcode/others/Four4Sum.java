package others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Four4Sum {

	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (num.length < 4) // no answer !!! 
			return result;
		Arrays.sort(num);
		
		for (int i = 0; i < num.length; i++) {
			if (i != 0 && num[i] == num[i - 1]) // skip duplicate
				continue;

			for (int j = i + 1; j < num.length; j++) {
				if (j != i + 1 && num[j] == num[j - 1]) // skip duplicate
					continue;
				int start = j + 1;
				int end = num.length - 1;
				while (start < end) {

					int currentValue = num[i] + num[j] + num[start] + num[end];
					if (currentValue == target) {
						ArrayList<Integer> current = new ArrayList<Integer>();
						current.add(num[i]);
						current.add(num[j]);
						current.add(num[start]);
						current.add(num[end]);
						result.add(current);

						start++;
						end--;

						// skip duplicate
						while (start < end && num[start] == num[start - 1])
							start++;
						while (start < end && num[end] == num[end + 1])
							end--;
					} else if (currentValue > target) {
						end--;
					} else {
						start++;
					}
				}
			}
		}
		return result;
	}
}
