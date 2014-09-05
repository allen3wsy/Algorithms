package others;

public class MinimumPathSum {

	// http://gongxuns.blogspot.com/2012/12/leetcodeminimum-path-sum.html
	// O(N2) time and O(N) space
	public int minPathSum(int[][] grid) {

		int[] row = new int[grid[0].length];

		// initializing the first line
		row[0] = grid[0][0];
		for (int j = 1; j < grid[0].length; j++)
			row[j] = row[j - 1] + grid[0][j];

		for (int i = 1; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (j > 0)
					row[j] = Math.min(row[j - 1], row[j]); // Math.min(left, up)
				row[j] += grid[i][j]; // adding itself
			}
		}
		return row[grid[0].length - 1];
	}
}
