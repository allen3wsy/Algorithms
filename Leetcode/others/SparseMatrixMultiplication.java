package others;

// http://www.cnblogs.com/grandyang/p/5282959.html
/**
 * Key point: list out this equation below:
 * 
 * C[i][j] = A[i][0]*B[0][j] + A[i][1]*B[1][j] + ... + A[i][k]*B[k][j]，
 * or C[i][j] = A[i][k]*B[k][j]; (k is from 0 to n - 1)
 */
public class SparseMatrixMultiplication {
    public int[][] multiply(int[][] A, int[][] B) {
        // Assume they are both non-empty.
        int m = A.length;
        int n = B.length;
        int p = B[0].length;
        int[][] res = new int[m][p];
                
        // for(int i = 0; i < m; i++){
        //     for(int k = 0; k < n; k++){
        //          for(int j = 0; j < p; j++){
        //              res[i][j] += A[i][k] * B[k][j];
        //          }
        //     }
        // }
        
		// improved on upper version, this is a math solution
		for (int i = 0; i < m; i++) {
			for (int k = 0; k < n; k++) {
				if (A[i][k] != 0) { // check not equal to 0
					for (int j = 0; j < p; j++) {
						if (B[k][j] != 0) { // check not equal to 0
							res[i][j] += A[i][k] * B[k][j];
						}
					}
				}
			}
		}
        return res;
    }
}
