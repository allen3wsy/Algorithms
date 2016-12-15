package interviewFLGT;

public class QuickSelect {

	private static void swap(int[] num, int left, int right) {
		int temp = num[left];
		num[left] = num[right];
		num[right] = temp;
	}

	// return the pivot index from[l, r]
	private static int partition(int[] num, int left, int right) {
		/**
		 * if we pick a pivot in the middle, we can swap it to num[right]
		 */
		int pValue = num[right];// choose the rightmost element as pivot
		int storeIndex = left;// start from left of the subarray.

		// for-loop swap all the elements that are smaller than the pivot.
		for (int i = left; i <= right - 1; i++) {
			if (num[i] <= pValue) {
				swap(num, i, storeIndex);
				storeIndex++;
			}
		}
		// storeIndex should be the correct index for pivot
		num[right] = num[storeIndex];
		num[storeIndex] = pValue; // pValue to the pivot
		return storeIndex; // which is the pivot index to return
	}

	// return k-th smallest element: [0, k - 1]: zero-based
	public static int quickSelect(int[] num, int k) {
		int start = 0;
		int end = num.length - 1;

		// a little bit like binary search
		while (start <= end) {
			int pivotIndex = partition(num, start, end);
			if (k == pivotIndex) {
				return num[pivotIndex];
			} else if (k < pivotIndex) {
				end = pivotIndex - 1;
			} else {
				start = pivotIndex + 1;
			}
		}
		return num[0]; // error case: if k is not in the range: [0, n - 1]
	}

	public static void main(String[] args) {
		int[] array = { 1, 4, 3, 2, 5 };
		System.out.println(quickSelect(array, 3));
	}
}
