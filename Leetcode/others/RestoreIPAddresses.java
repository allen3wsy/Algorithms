package others;

import java.util.ArrayList;

public class RestoreIPAddresses {

	// http://blog.csdn.net/u011095253/article/details/9158449
	// isValid helper function is also
	public ArrayList<String> restoreIpAddresses(String s) {
		ArrayList<String> result = new ArrayList<String>();
		if (s.length() < 4 || s.length() > 12)
			return result;
		dfs(s, "", result, 0);
		return result;
	}

	/**
	 * s: the remaining part of the string temp: the current ip so far count:
	 * means the number of "." so far
	 */
	public void dfs(String s, String temp, ArrayList<String> result, int count) {
		if (count >= 4) // pruning: added by Allen Wu
			return;
		if (count == 3 && isValid(s)) {
			result.add(temp + s);
			return;
		}

		// don't forget i < s.length(): because if s.length == 0 then we should
		// DO NOTHING !!!
		// at most 3 branches (at most 3 digits)
		for (int i = 1; i <= 3 && i < s.length(); i++) {
			String substr = s.substring(0, i);
			if (isValid(substr)) {
				// substring(i): [i, end]
				dfs(s.substring(i), temp + substr + '.', result, count + 1);
			}
		}

		for (int i = 1; i <= 3 && i < s.length(); i++) {
			String substr = s.substring(0, i);
			if (isValid(substr)) {
				dfs(s.substring(i), temp + substr + '.', result, count + 1);
			}
		}
	}

	// must be "0" "122", etc... : "02" not Valid
	public boolean isValid(String s) {
		if (s.charAt(0) == '0')
			return s.equals("0");
		int num = Integer.parseInt(s);
		return num <= 255 && num >= 0;
	}
}
