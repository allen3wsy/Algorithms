package interviewFLGT;

// DONE!
public class findGreatestSum {

	public static void findGreatestSum() {

		int[] arr = { 1, -2, 3, 10, -4, 7, 2, -5, -10000, 10000 };
		int finalMax = 0;
		int currMax = 0;

		int recent_start = 0;
		int finalEndPosition = 0;
		int finalStartPosition = 0;

		for (int i = 0; i < arr.length; i++) {
			currMax += arr[i];
			if (currMax < 0) { // no contribution to latter sub arr
				currMax = 0;
				recent_start = i + 1; // this statement is important !!!
			}
			if (currMax > finalMax) {
				finalMax = currMax;
				finalEndPosition = i;
				finalStartPosition = recent_start;
			}
		}

		if (finalMax == 0) { // Special case: if all elements are negative !
			finalMax = arr[0];
			for (int i = 0; i < arr.length; i++) {
				if (finalMax < arr[i]) {
					finalMax = arr[i];
					finalStartPosition = finalEndPosition = i;
				}
			}
		}

		System.out.println("The max sum is " + finalMax + " position:"
				+ finalStartPosition + "," + finalEndPosition);
	}

	public static void main(String[] args) {

		// start position is wrong !!!
		// but end position is right !!!
		findGreatestSum();
	}
}
