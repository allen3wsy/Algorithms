package others;

public class PalindromePartitioning2 {

	// http://fisherlei.blogspot.com/2013/03/leetcode-palindrome-partitioning-ii.html
	// http://blog.csdn.net/worldwindjp/article/details/22066307
	// DP solution: (2-D)
	public int minCut(String s) {
		int len = s.length();

		int[] D = new int[len + 1];
		boolean[][] P = new boolean[len][len];

		// The worst case is cutting by each char
		for (int i = 0; i <= len; i++)
			D[i] = len - i - 1;

		for (int i = len - 1; i >= 0; i--) {
			for (int j = i; j < len; j++) {
				if (s.charAt(i) == s.charAt(j)
						&& (j - i <= 1 || P[i + 1][j - 1])) {
					P[i][j] = true;
					D[i] = Math.min(D[i], D[j + 1] + 1);
				}
			}
		}

		return D[0];
	}
	
}
