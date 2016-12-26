package binarySearch;

public class FirstBadVersion {

	public static boolean isBadVersion(int i) {
		return true;
	}

	public static int firstBadVersion(int n) {
		if (n == 1) {
			return 1;
		}
		int left = 1;
		int right = n;

		while (left < right) {
			int mid = left + (right - left) / 2;
			if (isBadVersion(mid)) { 
				// if mid is bad, it might be the first bad
				right = mid;
			} else {
				// if mid is not bad, it cannot be the first bad
				left = mid + 1;
			}
		}
		// now: left == right
		return right; // return left is the same.
	}
}
