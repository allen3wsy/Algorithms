package dp;

public class DecodeWays {

	// Very good DP solution !!!
	// pay attention to the index thing: dp[i] corresponds to s.charAt(i - 1)
	// http://blog.csdn.net/u011095253/article/details/9248109
	public static int numDecodings(String s) {
		if (s.length() == 0 || s == null)
			return 0;
		int[] dp = new int[s.length() + 1]; // DP array must be length (n + 1)

		dp[0] = 1; // base case !!! dp[0] = 1
		if (isValid(s.substring(0, 1)))
			dp[1] = 1;// dp[1] = 1 or 0 (but outside the for loop)
		else
			dp[1] = 0;

		// dp[i] corresponds to s.charAt(i - 1)
		for (int i = 2; i <= s.length(); i++) {
			if (isValid(s.substring(i - 1, i)))
				dp[i] += dp[i - 1]; // dp[i] is initialized to be 0
			if (isValid(s.substring(i - 2, i)))
				dp[i] += dp[i - 2];
		}
		return dp[s.length()];
	}

	public static boolean isValid(String s) { // the length must be length 1 to 2
		// this if block is optional.
		if (s.length() != 1 && s.length() != 2)
			return false;
		
		if (s.charAt(0) == '0') // if it is like: 01, 02 then NOT valid !!!!
			return false;
		int code = Integer.parseInt(s);
		return code >= 1 && code <= 26;
	}
	
	public static void main(String[] args) {
		System.out.println("num of decode ways: " + numDecodings("2121"));
	}
}
