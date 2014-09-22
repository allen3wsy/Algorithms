package interviewFLGT;

import java.util.ArrayList;
import java.util.Arrays;

// LinkedIn onsite
public class UniqueCombination_LinkedIn {

	public static void countUnique(int n, ArrayList<ArrayList<Integer>> result) {

		for (int i = 1; i <= n / 2; i++) {

			if (i == 1) {
				countUnique(n - i, result);
				for (ArrayList<Integer> array : result) {
					array.add(1);
				}
			}
			result.add(new ArrayList<Integer>(Arrays.asList(i, n - i)));
		}
		return;
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		countUnique(5, result);
		System.out.println(result);
	}
}
