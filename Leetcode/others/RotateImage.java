package others;

public class RotateImage {

	// another solution: not the easiest one.
    // http://www.programcreek.com/2013/01/leetcode-rotate-image-java/

    // By using the relation "matrix[i][j] = matrix[n-1-j][i]", we can loop through the matrix.
	public void rotate(int[][] matrix) {
    	int n = matrix.length;
    	for (int i = 0; i <= n / 2 - 1; i++) {
    		for (int j = 0; j <= (n - 1) / 2; j++) { // remember this Math.ceil() function
    			int temp = matrix[i][j];
    			matrix[i][j] = matrix[n - 1 - j][i];
    			matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
    			matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
    			matrix[j][n - 1 - i] = temp;
    		}
    	}
    }
}
