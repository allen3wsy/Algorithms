package leetcode;

public class RemoveDuplicatesFromSortedArray {

	public int removeDuplicates(int[] A) {
		int length = A.length;
		int dupCount = 0;

		for (int i = 1; i < length; i++) {
			if (A[i] == A[i - 1]) {
				dupCount++;
			} else {
				A[i - dupCount] = A[i];
			}
		}

		return length - dupCount;
	}
}
