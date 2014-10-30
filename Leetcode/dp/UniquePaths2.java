package dp;

public class UniquePaths2 {

	// http://blog.csdn.net/u010500263/article/details/18853041
	// this approach requires no space: just the original O(n 2) space:
	// change 1 to -1 so that it will cause no conflict!!!

	// my method needs O(N 2) space
	// O(n 2) space and time
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

		if (obstacleGrid == null || obstacleGrid.length == 0
				|| obstacleGrid[0].length == 0)
			return 0;

		int rows = obstacleGrid.length;
		int cols = obstacleGrid[0].length;
		if (obstacleGrid[rows - 1][cols - 1] == 1 || obstacleGrid[0][0] == 1)
			return 0;

		int[][] path = new int[rows][cols];

		for (int i = 0; i < cols; i++) {
			if (obstacleGrid[0][i] != 1)
				path[0][i] = 1;
			else { // it is an obstacle, then cannot pass it, all paths right
				break; // would be 0
			}
		}

		for (int i = 0; i < rows; i++) {
			if (obstacleGrid[i][0] != 1)
				path[i][0] = 1;
			else { // it is an obstacle, then cannot pass it, all paths down
				break; // would be 0
			}
		}

		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < cols; j++) {
				if (obstacleGrid[i][j] == 0) {
					if (obstacleGrid[i - 1][j] == 0)
						path[i][j] += path[i - 1][j];
					if (obstacleGrid[i][j - 1] == 0)
						path[i][j] += path[i][j - 1];
				}
			}
		}

		return path[rows - 1][cols - 1];
	}

	public static void main(String[] args) {
		int[][] obstacleGrid = { { 0, 0, 0 }, { 1, 0, 0 }, { 1, 0, 0 } };

		// correct
		System.out.println(uniquePathsWithObstacles(obstacleGrid));
		
	}
}
