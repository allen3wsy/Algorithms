package two_Dimensional_DP;

//The longest common subsequence of two string
/**
 * Youtube explanation !!! https://www.youtube.com/watch?v=P-mMvhfJhu8
 * 
 * @author AllenNg
 */
// // initialization
// for (int i = 0; i <= m; i++)
// matrix[i][0] = 0;
// for (int j = 0; j <= n; j++)
// matrix[0][j] = 0;
public class LongestCommonSubsequence {

	public static String longestCommonSubsequence(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		int[][] matrix = new int[m + 1][n + 1]; // 2-D array: (m + 1) * (n + 1)

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= m; i++) { // dynamic programming
			for (int j = 1; j <= n; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					matrix[i][j] = matrix[i - 1][j - 1] + 1;
				} else {
					matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - 1]);
				}
			}
		}
		// the remaining part to trace back !!!
		int i = m;
		int j = n;
		// now starts from lower right corner matrix[m][n]
		while (matrix[i][j] > 0) { // trace back to print the LCS
			if (s1.charAt(i - 1) == s2.charAt(j - 1)) { // go upperLeft
				// can also use: sb.insert(0, s1.charAt(i - 1));
				sb.insert(0, s1.charAt(i - 1));
				i--;
				j--;
			} else {
				if (matrix[i][j - 1] == matrix[i][j])
					j--; // go left
				else
					i--; // go up
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(longestCommonSubsequence("ABCBDAB", "BDCABA"));
	}
}