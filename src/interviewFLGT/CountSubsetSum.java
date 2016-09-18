package interviewFLGT;

/**
 * Allen's LinkedIn onsite
 * @author AllenNg
 */
public class CountSubsetSum {

	// [1,2,2] 3
	public static int countSubsetSum(int[] arr, int target) {
		int length = arr.length;

		int[][] table = new int[length][target + 1];
		table[0][0] = 1;

		for (int i = 1; i <= target; i++) {
			if (arr[0] == i)
				table[0][i] = 1;
		}

		for (int i = 1; i < length; i++) {
			for (int j = 0; j < target + 1; j++) {
				table[i][j] = table[i - 1][j];
				if (j - arr[i] >= 0)
					table[i][j] += table[i - 1][j - arr[i]];
			}
		}

		return table[length - 1][target];
	}

	public static void main(String[] args) {
		int[] arr = { 3, 0, 3 };
		int target = 3;
		System.out.println(countSubsetSum(arr, target));
	}
}
