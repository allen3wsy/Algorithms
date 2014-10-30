package dp;

public class InterleavingString {

	// http://gongxuns.blogspot.com/2012/12/public-class-solution-public-boolean.html
	public boolean isInterleave(String s1, String s2, String s3) {
		if (s3.length() != s1.length() + s2.length())
			return false;

		boolean[][] match = new boolean[s1.length() + 1][s2.length() + 1];
		match[0][0] = true;

		int i = 1;
		while (i <= s1.length() && s1.charAt(i - 1) == s3.charAt(i - 1)) {
			match[i][0] = true;
			i++;
		}

		i = 1;
		while (i <= s2.length() && s2.charAt(i - 1) == s3.charAt(i - 1)) {
			match[0][i] = true;
			i++;
		}

		for (i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				char c = s3.charAt(i + j - 1);
				if (c == s1.charAt(i - 1))
					match[i][j] = match[i - 1][j];
				// if (c == s1.charAt(i - 1)) already makes match[i][j] true
				if (c == s2.charAt(j - 1)) // then it must be true
					match[i][j] = match[i][j - 1] || match[i][j];
			}
		}
		return match[s1.length()][s2.length()];
	}
}
