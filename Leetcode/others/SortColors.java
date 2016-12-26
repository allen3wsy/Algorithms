package others;

/**
 * 3 way partition Classic Dutch National Flag Problem.
 * 
 * @author AllenNg
 *
 */
public class SortColors {

	// KEY POINTS:
	public void sortColors(int[] A) {
		int red = 0;
		int blue = A.length - 1;
		int i = 0;

		// i should not be larger than blue
		while (i <= blue) {
			if (A[i] == 0) { // 0 means RED
				swap(A, i, red); // swap A[i] and A[red], increase i and red
				red++;
				i++;
			} else if (A[i] == 2) { // 2 means BLUE
				swap(A, i, blue); // swap A[i] and A[blue], BUT DON'T decrease i
				blue--;
			} else { // 1 is white...
				i++; // white, do nothing but increase i
			}
		}
	}

	public void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
}
