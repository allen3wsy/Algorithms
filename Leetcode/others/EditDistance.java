package others;

public class EditDistance {

	// http://www.programcreek.com/2013/12/edit-distance-in-java/
	// http://fisherlei.blogspot.com/2012/12/leetcode-edit-distance.html
	public static int minDistance(String word1, String word2) {
		int len1 = word1.length();
		int len2 = word2.length();

		int[][] result = new int[len1 + 1][len2 + 1];

		for (int i = 0; i <= len1; i++) {
			result[i][0] = i;
		}

		for (int j = 0; j <= len2; j++) {
			result[0][j] = j;
		}

		for (int i = 1; i <= len1; i++) {
			char c1 = word1.charAt(i - 1);

			for (int j = 1; j <= len2; j++) {
				char c2 = word2.charAt(j - 1);

				if (c1 == c2) { // equal, copy upperLeft value
					result[i][j] = result[i - 1][j - 1];
				} else {
					int tempMin = Math.min(result[i - 1][j], result[i][j - 1]);
					int min = Math.min(tempMin, result[i - 1][j - 1]);
					result[i][j] = min + 1; // EX: the min of the three and + 1
											// to this
				}
			}
		}
		return result[len1][len2];
	}
}
