package binarySearch;

/*
 * EITHER the left or right half must be normally sorted(AT LEAST ONE HALF OF THEM). 
 * Find out which side is normally 
 * ordered, and then use the normally ordered half to figure out which side to search to 
 * find x.
 */
public class SearchInRotatedSortedArray {

	// http://blog.csdn.net/linhuanmars/article/details/20525681
	public static int search(int[] A, int target) {
		if (A == null || A.length == 0)
			return -1;
		int l = 0;
		int r = A.length - 1;

		while (l <= r) {
			int m = (l + r) / 2;
			if (A[m] == target)
				return m;

			// from now on, A[m] != target
			if (A[l] < A[m]) { // left part is normally ordered
				if (A[l] <= target && target < A[m]) // also: target <= A[m]
					r = m - 1;
				else
					l = m + 1;
			} else if (A[l] > A[m]) { // right part is normally ordered
				if (A[m] < target && target <= A[r]) // also be: A[m] <= target
					l = m + 1;
				else
					r = m - 1;
			} else { // A[l] == A[m] means: there are (1 or 2) elements now!
				l++; // the line will only be executed 1 or 2 times (not O(N) !)
			}
		}
		return -1; // when (l > r)
	}

	/**
	 * search2 is a recursive solution !!!
	 */
	public int search2(int[] A, int target) {
		if (A == null || A.length == 0) {
			return -1;
		} else {
			return binarySearchRotatedRecursive(A, 0, A.length - 1, target);
		}
	}

	// helper
	public int binarySearchRotatedRecursive(int[] a, int left, int right,
			int target) {
		int mid = (left + right) / 2;
		if (target == a[mid]) {
			return mid;
		}
		if (left > right)
			return -1;

		if (a[left] < a[mid]) { // left is normally ordered
			if (target >= a[left] && target <= a[mid]) {
				return binarySearchRotatedRecursive(a, left, mid - 1, target);
			} else {
				return binarySearchRotatedRecursive(a, mid + 1, right, target);
			}
		} else if (a[left] > a[mid]) { // right is normally ordered
			if (target >= a[mid] && target <= a[right]) {
				return binarySearchRotatedRecursive(a, mid + 1, right, target);
			} else {
				return binarySearchRotatedRecursive(a, left, mid - 1, target);
			}
		} else { // a[left] == a[mid]: only 2 elements left
			if (a[right] == target)
				return right;
			else
				return -1;
		}
	}
}
