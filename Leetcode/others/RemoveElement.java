package others;

public class RemoveElement {

	public int removeElement(int[] A, int elem) {
		int N = A.length;
		int valueCount = 0;

		for (int i = 0; i < N; i++) {
			if (A[i] == elem)
				valueCount++;
			else
				A[i - valueCount] = A[i];
		}
		return N - valueCount;
	}
}
