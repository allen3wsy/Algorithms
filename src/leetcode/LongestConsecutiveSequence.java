package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

	public int longestConsecutive(int[] num) {
		Set<Integer> set = new HashSet<Integer>();
		int max = 1;

		for (int i : num)
			set.add(i);

		for (int i : num) {
			int left = i - 1;
			int right = i + 1;
			int count = 1;

			while (set.contains(left)) {
				count++;
				set.remove(left);
				left--;
			}

			while (set.contains(right)) {
				count++;
				set.remove(right);
				right++;
			}

			if (set.contains(i)) // these 2 lines should be added (clearer)
				set.remove(i); // should be added (clearer)
			max = Math.max(count, max);
		}
		return max;

	}
}
