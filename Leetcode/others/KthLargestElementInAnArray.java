package others;

/**
 * Refer to {@code QuickSelect}
 */
public class KthLargestElementInAnArray {

	// Firstly, PriorityQueue(Heap):
	// We can use a min heap to solve this problem. The heap stores the top k
	// elements. Whenever the size is greater than k, delete the min. Time
	// complexity is O(Nlog(K)). Space complexity is O(k) for storing the top k
	// numbers.
	// Secondly, Sort (NlgN)
	// Thirdly, QuickSelect: Time Avg O(N) Worst O(N^2) Space: O(1)

	// return the pivot index from[l, r]
	private static int partition(int[] num, int left, int right) {
		/**
		 * if we pick a pivot in the middle, we can swap it to num[right]
		 */
		int pValue = num[right];// choose the rightmost element as pivot
		int storeIndex = left;// start from left of the subarray.

		// for-loop swap all the elements that are larger than the pivot.
		for (int i = left; i <= right - 1; i++) {
			if (num[i] >= pValue) {
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
	// changed to one-based K: [1, N]
	public static int findKthLargest(int[] num, int k) {
		int start = 0;
		int end = num.length - 1;

		// a little bit like binary search: but Iterative here
		while (start <= end) {
			int pivotIndex = partition(num, start, end);
			if (k - 1 == pivotIndex) {
				return num[pivotIndex];
			} else if (k - 1 < pivotIndex) {
				end = pivotIndex - 1;
			} else { // k > pivotIndex
				start = pivotIndex + 1;
			}
		}
		return num[0]; // error case: if k is not in the range: [0, n - 1]
	}

	private static void swap(int[] num, int left, int right) {
		int temp = num[left];
		num[left] = num[right];
		num[right] = temp;
	}

	public static void main(String[] args) {
		int[] num = { 56, 2, 2, 0, 1, 1, 4, 5, 5, 7, 3 };
	}
}
