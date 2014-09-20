package palindrome;

import java.util.ArrayList;

public class PalindromePartitioning {

	// http://blog.csdn.net/ljphhj/article/details/22573983
	// this is the DP+DFS solution !
	public static ArrayList<ArrayList<String>> partition(String s) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		if (s == null || s.length() == 0)
			return result;

		ArrayList<String> partition = new ArrayList<String>();
		boolean[][] matrix = new boolean[s.length()][s.length()];
		for (int i = s.length() - 1; i >= 0; i--) {
			for (int j = i; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j)) {
					if (j - i <= 1 || matrix[i + 1][j - 1]) {
						matrix[i][j] = true;
					}
				}
			}
		}
		addPalindrome(s, 0, partition, result, matrix);
		return result;
	}

	public static void addPalindrome(String s, int start,
			ArrayList<String> partition, ArrayList<ArrayList<String>> result,
			boolean[][] matrix) {
		// base case
		if(start == s.length()) {
			result.add(new ArrayList<String>(partition));
			return;
		}
		// recurse
		for(int i = start; i < s.length(); i++) {
			if(matrix[start][i]) {
				partition.add(s.substring(start, i + 1));
				addPalindrome(s, i + 1, partition, result, matrix);
				partition.remove(partition.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(partition("abacdc"));
	}
}
