package interviewFLGT;

public class FindMissing {

	public static int findMissing(int[] A) {

		int nBeg = 0;
		int nEnd = A.length - 1;

		while (nBeg < nEnd) {
			int nMid = (nBeg + nEnd) / 2;
			if (A[nMid] != nMid + 1)
				nEnd = nMid;
			else
				nBeg = nMid + 1;
		}
		return A[nEnd] - 1;
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 6, 7 };
		System.out.println(findMissing(array));
	}
}
