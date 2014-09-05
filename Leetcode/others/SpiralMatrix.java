package others;

import java.util.ArrayList;

public class SpiralMatrix {

	// http://www.programcreek.com/2013/01/leetcode-spiral-matrix-java/
	public ArrayList<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> result = new ArrayList<Integer>();

		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return result;

		int m = matrix.length;
		int n = matrix[0].length;

		int x = 0;
		int y = 0; // x and y are for the CURRENT coordinate of the traversal

		while (m > 0 && n > 0) { // should be both > 0, otherwise should be
									// continue

			// if one row/column left, no circle can be formed
			if (m == 1) {
				for (int i = 0; i < n; i++) { // one row...
					result.add(matrix[x][y++]);
				}
				break;
			} else if (n == 1) {
				for (int i = 0; i < m; i++) { // one column...
					result.add(matrix[x++][y]);
				}
				break;
			}

			// BELOW, process a circle !! more than 1 row or 1 column !!!
			// top - move right
			for (int i = 1; i <= n - 1; i++) { // this line, we traverse n - 1
												// elements, NOT the corner !
				result.add(matrix[x][y++]);
			}

			// right - move down
			for (int i = 1; i <= m - 1; i++) {
				result.add(matrix[x++][y]);
			}

			// bottom - move left
			for (int i = 1; i <= n - 1; i++) {
				result.add(matrix[x][y--]);
			}

			// left - move up
			for (int i = 1; i <= m - 1; i++) {
				result.add(matrix[x--][y]);
			}

			x++;
			y++;
			m = m - 2;
			n = n - 2;
		}

		return result;

	}
}
