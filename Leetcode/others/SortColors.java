package others;

public class SortColors {

	public void sortColors(int[] A) {
		int red = 0;
		int blue = A.length - 1;

		int i = 0;

		// i should not be larger than blue
		while (i <= blue) {
			if (A[i] == 0) {

				// swap and increase i and red
				int temp = A[i];
				A[i] = A[red];
				A[red] = temp;
				red++;
				i++;
			} else if (A[i] == 2) {
				// swap but dont' increase i
				int temp = A[i];
				A[i] = A[blue];
				A[blue] = temp;
				blue--;

			} else {
				i++; // white, do nothing but increase i
			}
		}
	}
}
