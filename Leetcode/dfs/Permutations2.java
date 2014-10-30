package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

public class Permutations2 {

	public static ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		int n = num.length;
		boolean[] visited = new boolean[n];

		Arrays.sort(num); // diff: this is different from Permutation I
		permuteHelper(result, temp, num, visited);
		return result;
	}

	public static void permuteHelper(ArrayList<ArrayList<Integer>> result,
			ArrayList<Integer> temp, int[] num, boolean[] visited) {
		if (temp.size() == num.length) {
			result.add(new ArrayList<Integer>(temp));
			return;
		}

		for (int i = 0; i < num.length; i++) {

			if (!visited[i]) {
				visited[i] = true;
				temp.add(num[i]);
				permuteHelper(result, temp, num, visited);
				temp.remove(temp.size() - 1);
				visited[i] = false;

				while (i < num.length - 1 && num[i + 1] == num[i]) { // skip_duplicates
					i++; // diff: should be different from Permutation I
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] num = { 1, 1, 1, 4 };
		System.out.println(permuteUnique(num));

	}
}
