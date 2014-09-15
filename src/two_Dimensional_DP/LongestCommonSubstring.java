package two_Dimensional_DP;

//// initialization
//for (int i = 0; i <= m; i++)
//matrix[i][0] = 0;
//for (int j = 0; j <= n; j++)
//matrix[0][j] = 0;
public class LongestCommonSubstring {

	/**
	 * find longest common substring with O(n*m) space
	 */
	public static String longestCommonSubstring(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0)
			return null;

		int maxLength = 0;
		int endIndex = 0;
		int m = s1.length();
		int n = s2.length();
		int[][] matrix = new int[m + 1][n + 1];

		/* important */
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					matrix[i][j] = matrix[i - 1][j - 1] + 1;

					// change the maxLength inorder to chase back easily
					if (matrix[i][j] > maxLength) {
						maxLength = matrix[i][j];
						endIndex = i - 1; // charAt(i - 1)
					}
				} else {
					// zero means that no common here
					matrix[i][j] = 0;
				}
			}
		}
		int startIndex = endIndex - maxLength + 1;
		return s1.substring(startIndex, endIndex + 1); // [start, end + 1)
	}

	/*
	 * find longest common substring with O(n) space
	 */
	public String LCSn(String first, String second) {
		if (first == null || second == null || first.length() == 0
				|| second.length() == 0) {
			return "";
		}

		int maxLength = 0;
		int end = 0;
		int record = 0;
		int fl = first.length(), sl = second.length();
		int[] past = new int[sl];
		int[] curr = new int[sl];

		for (int i = 0; i < fl; i++) {
			for (int j = 0; j < sl; j++) {
				if (first.charAt(i) != second.charAt(j)) {
					record = 0;
				} else {
					if (i == 0 || j == 0) {
						record = 1;
					} else {
						record = past[j - 1] + 1;
					}
				}
				curr[j] = record;
				if (record > maxLength) {
					maxLength = record;
					end = i;
				}
			}
			int[] swap = past;
			past = curr;
			curr = swap;
		}
		System.out.println("maxLength: " + maxLength + "  end: " + end);
		return first.substring(end - maxLength + 1, end + 1);
	}

	public static void main(String[] args) {
		System.out.println(longestCommonSubstring("abcd", "kbck"));
		System.out.println(longestCommonSubstring("abcd", "abcd"));

	}
}