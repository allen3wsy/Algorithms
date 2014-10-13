package binarySearch;

public class MedianOfTwoSortedArrays {

	// http://www.programcreek.com/2012/12/leetcode-median-of-two-sorted-arrays-java/
	public static double findMedianSortedArrays(int A[], int B[]) {
		if (A == null || A.length == 0)
			return simpleMedian(B);
		if (B == null || B.length == 0)
			return simpleMedian(A);

		if ((A.length + B.length) % 2 != 0) // odd
			return (double) findKth(A, B, (A.length + B.length) / 2, 0,
					A.length - 1, 0, B.length - 1);
		else { // even
			return (findKth(A, B, (A.length + B.length) / 2, 0, A.length - 1,
					0, B.length - 1) + findKth(A, B,
					(A.length + B.length) / 2 - 1, 0, A.length - 1, 0,
					B.length - 1)) / 2.0;
		}
	}

	// k is zero-based: [0, n]: Wanna find the second smallest num? then k == 1
	public static int findKth(int A[], int B[], int k, int aStart, int aEnd,
			int bStart, int bEnd) {

		int aLen = aEnd - aStart + 1;
		int bLen = bEnd - bStart + 1;
		// Handle special cases
		if (aLen == 0)
			return B[bStart + k];
		if (bLen == 0)
			return A[aStart + k];
		if (k == 0) // k will never be smaller than 0 (k >=0)
			return A[aStart] < B[bStart] ? A[aStart] : B[bStart];

		int aMidLen = aLen * k / (aLen + bLen); // a's middle count
		int bMidLen = k - aMidLen - 1; // b's middle count
		// make aMid and bMid to be array index
		int aMid = aMidLen + aStart; // proportionally mid
		int bMid = bMidLen + bStart; // proportionally mid

		if (A[aMid] > B[bMid]) {
			k = k - (bMid - bStart + 1);
			aEnd = aMid; // aEnd is included !
			bStart = bMid + 1;
		} else if (A[aMid] < B[bMid]) {
			k = k - (aMid - aStart + 1);
			bEnd = bMid; // bEnd is included !
			aStart = aMid + 1;
		} else { // A[aMid] == B[bMid]
			return A[aMid]; // or B[bMid]
		}
		return findKth(A, B, k, aStart, aEnd, bStart, bEnd);
	}

	// if none of A & B is null, then this method is not useful
	private static double simpleMedian(int A[]) {
		int n = A.length;
		if (n % 2 == 1) // odd number
			return A[n / 2];
		return (A[n / 2 - 1] + A[n / 2]) / 2.0;
	}

	public static void main(String[] args) {
		int[] A = { 2, 3, 4, 5, 10 };
		int[] B = { 1, 6, 7, 8, 9 };

		System.out.println(findMedianSortedArrays(A, B));
	}
}
