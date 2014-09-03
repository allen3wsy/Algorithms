package leetcode;

public class SearchInRotatedSortedArray2 {

	public boolean search(int[] A, int target) {
		int result = binarySearchRotatedRecursive(A, 0, A.length - 1, target);
		if (result == -1)
			return false;
		else
			return true;
	}

	// consider tricky case !!! [2, 2, 2, 3, 4, 2]...... time: O(N)
	// helper
	public static int binarySearchRotatedRecursive(int[] a, int left,
			int right, int x) {
		int mid = (left + right) / 2;
		if (x == a[mid]) {
			return mid;
		}
		if (left > right)
			return -1;

		/*
		 * EITHER the left or right half must be normally sorted(AT LEAST ONE
		 * HALF OF THEM). Find out which side is normally ordered, and then use
		 * the normally ordered half to figure out which side to search to find
		 * x.
		 */
		// CASE 1:
		if (a[left] < a[mid]) { // left is normally ordered
			if (x >= a[left] && x <= a[mid]) { // to see if it is within left
												// side
				return binarySearchRotatedRecursive(a, left, mid - 1, x);
			} else {
				return binarySearchRotatedRecursive(a, mid + 1, right, x);
			}

			// CASE 2:
		} else if (a[mid] < a[left]) { // right is normally ordered
			if (x >= a[mid] && x <= a[right]) { // to see if it is within right
												// side
				return binarySearchRotatedRecursive(a, mid + 1, right, x);
			} else {
				return binarySearchRotatedRecursive(a, left, mid - 1, x);
			}

			// CASE 3:
		} else if (a[left] == a[mid]) { // left half is all repeats !!!!!!
			if (a[mid] != a[right]) { // if right is diff from mid, search the
										// right half
				return binarySearchRotatedRecursive(a, mid + 1, right, x);
			} else { // ELSE: we have to search BOTH HALVES
				int result = binarySearchRotatedRecursive(a, left, mid - 1, x); // search
																				// left
				if (result == -1) { // Must be on the right side
					return binarySearchRotatedRecursive(a, mid + 1, right, x); // search
																				// right
				} else {
					return result;
				}
			}
		}
		return -1;
	}
}
