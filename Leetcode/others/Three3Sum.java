package others;

import java.util.ArrayList;
import java.util.Arrays;

public class Three3Sum {

	public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length <= 2)
			return result;
		Arrays.sort(num);

		for (int i = 0; i < num.length - 2; i++) {
			// THIS LINE IS EXTREMELY IMPORTANT: avoid duplicate solutions
			if (i != 0 && num[i] == num[i - 1]) 
				continue; // avoid duplicates !!!
			
			// APPLY 2 SUM here:
			int negate = -num[i];
			int left = i + 1;
			int right = num.length - 1;

			while (left < right) { // start
				if (num[left] + num[right] == negate) {
					result.add(new ArrayList<Integer>(Arrays.asList(num[i],
							num[left], num[right])));
					left++;
					right--;
					// EX: avoiding duplicate solutions in the 2 SUM problem
					while (left < right && num[left] == num[left - 1])
						left++;
					while (left < right && num[right] == num[right + 1])
						right--;
				} else if (num[left] + num[right] < negate) {
					left++;
				} else { // num[start] + num[end] > negate
					right--;
				}
			}
		}
		return result;
	}
}
