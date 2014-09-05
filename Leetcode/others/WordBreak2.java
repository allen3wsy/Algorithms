package others;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class WordBreak2 {

	public static ArrayList<String> wordBreak(String s, Set<String> dict) {

		ArrayList<String> solution = new ArrayList<String>();
		int len = s.length();
		
		boolean[] possible = new boolean[len + 1];
		for (int i = 0; i < possible.length; i++) {
			possible[i] = true;
		}
		String ret = "";
		GetAllSolutionDFS(0, s, len, dict, ret, solution, possible);
		
		for (int i = 0; i < possible.length; i++) {
			System.out.print(possible[i] + " ");
		}
		
		return solution;
	}

	// DFS + DP !!! DP: adding in the (boolean[] possible)
	public static void GetAllSolutionDFS(int start, String s, int size, Set<String> dict,
			String result, ArrayList<String> sol, boolean[] possible) {

		if (start == size) {
			sol.add(result.substring(0, result.length() - 1));		// delete the rightmost space (" ")
			return;
		}

		for (int i = start; i < size; i++) 	{
			String piece = s.substring(start, i + 1);

			// typical DFS: first add piece to ret, and then minus piece from
			// ret
			if (dict.contains(piece) && possible[i + 1]) {
				result = result + piece + " ";
				int before = sol.size();
				GetAllSolutionDFS(i + 1, s, size, dict, result, sol, possible);
				
				if (sol.size() == before) 	{// which means from [i + 1], it fails
					possible[i + 1] = false;
					System.out.println("possible " + (i + 1) + " has been made false");
				}
				result = result.substring(0, result.length() - piece.length() - 1);
			}
		}
	}

	public static void main(String[] args) {
    	String s = "catsanddogk";
    	Set<String> dict = new HashSet<String>();
    	
    	dict.add("cat");
    	dict.add("cats");
    	dict.add("and");
    	dict.add("sand");
    	dict.add("anddog");
    	
    	ArrayList<String> array = wordBreak(s, dict);
    	System.out.println();
    	System.out.println(array);
    	
	}
}
