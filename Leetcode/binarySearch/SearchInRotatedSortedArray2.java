package binarySearch;

/*
 * EITHER the left or right half must be normally sorted(AT LEAST ONE
 * HALF OF THEM). Find out which side is normally ordered, and then use
 * the normally ordered half to figure out which side to search to find
 * x.
 */

public class SearchInRotatedSortedArray2 {
	/**
	 * good solution !! worst case is : O(N)
	 */
	// http://blog.csdn.net/linhuanmars/article/details/20588511
	public static boolean search(int[] A, int target) {
		if (A == null || A.length == 0)
			return false;
		int l = 0;
		int r = A.length - 1;

		while (l <= r) {
			int m = (l + r) / 2;
			if (A[m] == target)
				return true;

			// from now on, A[m] != target
			if (A[l] < A[m]) { // left part is normally ordered
				if (A[l] <= target && target < A[m]) // also be: target <= A[m]
					r = m - 1;
				else
					l = m + 1;
			} else if (A[l] > A[m]) { // right part is normally ordered
				if (A[m] < target && target <= A[r]) // also be A[m] <= target
					l = m + 1;
				else
					r = m - 1;
			} else { // (A[l] == A[m]) != target, move it, that's why it is O(N)
				l++; // decrease the range by 1...
			}
		}
		return false; // when (l > r)
	}

	/**
	 * Recursive solution !!!
	 */
	public boolean search2(int[] A, int target) {
		int result = binarySearchRotatedRecursive(A, 0, A.length - 1, target);
		if (result == -1)
			return false;
		else
			return true;
	}

	// consider tricky case !!! [2, 2, 2, 3, 4, 2]...... time: O(N)
	public static int binarySearchRotatedRecursive(int[] a, int left,
			int right, int x) {
		int mid = (left + right) / 2;
		if (x == a[mid]) {
			return mid;
		}
		if (left > right)
			return -1;

		if (a[left] < a[mid]) { // left is normally ordered
			if (x >= a[left] && x <= a[mid]) { // see if it's within left side
				return binarySearchRotatedRecursive(a, left, mid - 1, x);
			} else {
				return binarySearchRotatedRecursive(a, mid + 1, right, x);
			}
		} else if (a[mid] < a[left]) { // right is normally ordered
			if (x >= a[mid] && x <= a[right]) { // see if it's within right side
				return binarySearchRotatedRecursive(a, mid + 1, right, x);
			} else {
				return binarySearchRotatedRecursive(a, left, mid - 1, x);
			}
		} else if (a[left] == a[mid]) { // left half is all repeats !!!!!!
			if (a[mid] != a[right]) { // if right is diff from mid, search the
										// right half
				return binarySearchRotatedRecursive(a, mid + 1, right, x);
			} else { // ELSE: we have to search BOTH HALVES
				int result = binarySearchRotatedRecursive(a, left, mid - 1, x); // left
				if (result == -1) { // Must be on the right side
					return binarySearchRotatedRecursive(a, mid + 1, right, x); // right
				} else {
					return result;
				}
			}
		}
		return -1;
	}
}
