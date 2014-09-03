package leetcode;

public class UniquePaths {

	public int uniquePaths(int m, int n) {
		int[] array = new int[n];

		array[0] = 1;

		// reduce space: from O(mn) to O(n)
		for (int i = 0; i < m; i++) {
			for (int j = 1; j < n; j++) {
				array[j] = array[j - 1] + array[j];
			}
		}

		return array[n - 1];
	}
}
