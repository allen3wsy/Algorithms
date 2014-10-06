package others;

public class SpiralMatrix2 {

	public int[][] generateMatrix(int n) {
		if (n < 0)
			return null;
		int[][] matrix = new int[n][n];

		// here: no need to instantiate m and n !!! becaues n is given
		int x = 0;
		int y = 0;
		int num = 1; // the num to be added to the matrix
		
		while (n > 0) {
			if (n == 1) { // if one entry left, no circle can be formed
				matrix[x][y] = num;
			}
			for (int i = 1; i <= n - 1; i++) { // to right
				matrix[x][y++] = num++;
			}
			for (int i = 1; i <= n - 1; i++) { // to down
				matrix[x++][y] = num++;
			}
			for (int i = 1; i <= n - 1; i++) { // to left
				matrix[x][y--] = num++;
			}
			for (int i = 1; i <= n - 1; i++) { // to up
				matrix[x--][y] = num++;
			}
			x++;
			y++;
			n = n - 2;
		}
		return matrix;
	}
}
