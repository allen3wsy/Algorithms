package dp;

public class MaximumProductSubarray {

	public int maxProduct(int[] A) {
		if (A.length == 0 || A == null)
			return 0;

		int result = A[0];
		int curMax = A[0];
		int curMin = A[0];

		for (int i = 1; i < A.length; i++) {
			int tempA = A[i] * curMax;
			int tempB = A[i] * curMin;

			// take the min or max out of the 3 variables
			curMax = Math.max(Math.max(tempA, tempB), A[i]);
			curMin = Math.min(Math.min(tempA, tempB), A[i]);
			if (curMax > result)
				result = curMax;
		}
		return result;
	}
}
