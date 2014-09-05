package others;

public class RemoveDuplicatesFromSortedArray2 {

	public int removeDuplicates(int[] A) {
		if (A.length <= 2)
			return A.length;

		// right now the length >= 3
		int prev = 1; // point to previous
		int curr = 2; // point to current

		while (curr < A.length) {
			if (A[curr] == A[prev] && A[curr] == A[prev - 1]) {
				curr++;
			} else {
				prev++;
				A[prev] = A[curr]; // curr always points to the current valid
									// position.
				curr++; // so that the result should be: prev + 1
			}
		}
		return prev + 1;
	}
}
