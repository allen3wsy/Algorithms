package others;

public class SetMatrixZeroes {

	public void setZeroes(int[][] matrix) {
		int m = matrix.length; // row
		int n = matrix[0].length; // column

		boolean[] row = new boolean[m];
		boolean[] col = new boolean[n]; // 2N space

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					row[i] = true;
					col[j] = true; // true means this row or column is equal to
									// zero
				}
			}
		}

		// set rows to zero
		for (int i = 0; i < m; i++) {
			if (row[i] == true) {
				for (int j = 0; j < matrix[0].length; j++) {
					matrix[i][j] = 0;
				}
			}
		}

		// set columns to zero
		for (int j = 0; j < n; j++) {
			if (col[j] == true) {
				for (int i = 0; i < matrix.length; i++) {
					matrix[i][j] = 0;
				}
			}
		}
	}
}
