package others;

public class DistinctSubsequences {

	// http://www.programcreek.com/2013/01/leetcode-distinct-subsequences-total-java/
	// http://blog.csdn.net/abcbc/article/details/8978146
	// Note: T is the smaller one!!!! Don't confuse T and S
	public int numDistinct(String S, String T) {
		int[][] dp = new int[T.length() + 1][S.length() + 1];

		for (int j = 0; j <= S.length(); j++) {
			dp[0][j] = 1;
		}

		for (int i = 1; i <= T.length(); i++) {
			for (int j = 1; j <= S.length(); j++) {
				dp[i][j] = dp[i][j - 1]; // at least the number left to it

				if (T.charAt(i - 1) == S.charAt(j - 1)) {
					dp[i][j] += dp[i - 1][j - 1]; // if the rightmost char equal
													// to each other, then add
													// the upperleft number
				}
			}
		}

		return dp[T.length()][S.length()];
	}
}
