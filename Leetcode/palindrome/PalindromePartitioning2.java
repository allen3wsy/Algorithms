package palindrome;

public class PalindromePartitioning2 {

	// http://fisherlei.blogspot.com/2013/03/leetcode-palindrome-partitioning-ii.html
	// http://blog.csdn.net/worldwindjp/article/details/22066307
	// DP solution: (2-D)
	public int minCut(String s) {
		int n = s.length();

		boolean[][] isPalindrome = new boolean[n][n];
		int[] minCutNumber = new int[n + 1];

		// The worst case is cutting by each char:
		// for: a b b c:
		// [4, 3, 2, 1, 0]
		for (int i = 0; i <= n; i++)
			minCutNumber[i] = n - i; // we can put minCutNumber[i] = n - i - 1;

		for (int i = n - 1; i >= 0; i--) {
			for (int j = i; j < n; j++) {
				if (s.charAt(i) == s.charAt(j)
						&& (j - i <= 1 || isPalindrome[i + 1][j - 1])) {
					isPalindrome[i][j] = true;
					minCutNumber[i] = Math.min(minCutNumber[i],
							minCutNumber[j + 1] + 1);
				}
			}
		}
		return minCutNumber[0] - 1;
	}
}
