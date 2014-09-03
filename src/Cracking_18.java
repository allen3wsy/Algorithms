
public class Cracking_18 {

	/**
	 * 18.1
	 * 
	 *  a is sum(without carry), b is carry
	 *  b will eventually be 0.
	 */
	public static int add(int a, int b) {
		if (b == 0) 
			return a;

		int sum = a ^ b; 			// add without carrying
		int carry = (a & b) << 1;	// carry, but don't add
		return add(sum, carry);   	// recurse
	}

	/**
	 * 18.2 
	 */
	// Math.random(): [0.0, 1.0) return double
	// [0.0, 1.0) * 101 => [0.0, 101.0) then cast it to int

	// result is: [0, 100] but there are 101 number split evenly
	/* Random number between lower and higher, inclusive */
	public static int rand(int lower, int higher) {
		return lower + (int) (Math.random() * (higher - lower + 1));
	}

	/*
	 * pick M elements from original array. Clone original array so that we
	 * don't destroy the input.
	 */
	public static int[] pickMRandomly(int[] original) {
		for (int i = 0; i < original.length; i++) { // length is 10
			int k = rand(0, i); 					// i: [0, 9], k:[0, i] 
			int temp = original[k];
			original[k] = original[i];
			original[i] = temp;
		}
		return original;
	}

	
	public static void main(String[] args) {
		
		/**
		 * 18.1
		 */
		System.out.println("sum is: " + add(2, 2));
		
		/**
		 * 18.2
		 */
		int[] cards = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] set = pickMRandomly(cards);

		for (int i : set) {
			System.out.print(i + " ");
		}

		System.out.println();
		System.out.println(rand(0, 10)); // [0, 10]

		// following 2 lines are the same
		System.out.println(rand(0, 1)); // [0, 1]
		System.out.println((int) (Math.random() * 2)); // [0, 1]

		/**
		 * 18.3
		 */
	}

}
