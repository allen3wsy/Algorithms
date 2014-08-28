package algo_Midlevel;
import java.util.ArrayList;


public class Longest_P_Substring {	
	/*
	 * DP solution:
	 * O(N 2) space and O(N 2) time one space: the current longest string
	 *
	 * k: k is the position difference: starting from 1 to n - 1 !
	 * */
	
	
	/*	Initialization 
	 * 	 a b a c
	 * a 1  
	 * b 1 1 
	 * a 1 1 1 
	 * c 1 1 1 1
	 *  */
	
	/*       a   b   c   b   a
	 *       0   1   2   3   4
	 * a  0  t   f   f   f   t
	 * b  1      t   f   t   f
	 * c  2          t   f   f
	 * b  3              t   f
	 * a  4                  t
	 */
	
	public static String longestPalindromeDP(String s)	{
		if(s == null || s.length() == 0)
			return null;
		if(s.length() == 1)
			return s;
		
		int maxLen = 1;
		int left = 0;
		int right = 0;
		
		
		boolean[][] matrix = new boolean[s.length()][s.length()];
		
		/* initialization: everything under the diagonal is true!!!
		 * */
		for(int i = 0; i < s.length(); i++)	{
			for(int j = 0; j < s.length(); j++)	{
				if(i >= j)
					matrix[i][j] = true;
				else
					matrix[i][j] = false;
			}
		}
		
		// // k is the difference !!!  Or current Length of the palin_length
		for(int k = 1; k <= s.length() - 1; k++)	{

			for(int i = 0; i + k < s.length(); i++)	{
				int j = i + k;
				if(s.charAt(i) == s.charAt(j))	{
					matrix[i][j] = matrix[i + 1][j - 1];	// check if inner substrings are palindrome
					if(matrix[i][j])	{
						if(j - i + 1 > maxLen){		// the length of the current string
							left = i;
							right = j;
							maxLen = j - i + 1;
						}
					}
				}	else	{
					matrix[i][j] = false;
				}
			}
		}
		
		String result = s.substring(left, right + 1);
		System.out.println("Longest Palindrome: " + result);
		return result;
	}
		
	/* a much simpler algorithm : Not DP !!!!!
	 * O(1) space and O(N 2) time   one space: the current longest string
	 * */
	public static String longestPalindrome(String s) {
		if (s.isEmpty()) 
			return null;
	
		if (s.length() == 1) 
			return s;
		
		String longest = s.substring(0, 1);
		
		for (int i = 0; i < s.length(); i++) {
			// get longest palindrome with center of (i)
			String tmp = helper(s, i, i);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}
	 
			// get longest palindrome with center of i, i+1
			tmp = helper(s, i, i + 1);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}
		}
	 
		return longest;
	}
		 
	// Given a center, either one letter or two letter, 
	// Find longest palindrome
	public static String helper(String s, int begin, int end) {
		while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
			begin--;
			end++;
		}
		return s.substring(begin + 1, end);
	}
	
	public static void main(String[] args)	{
		String str = "aba";
		System.out.println(longestPalindrome(str));
		longestPalindromeDP(str);
		System.out.println(str.substring(3,3));	 // in face this is right
	}
		
}
