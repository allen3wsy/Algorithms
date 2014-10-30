package interviewFLGT;

/**
 * Multiply 2 integers without using * operator !!!
 * 
 * @author AllenNg
 *
 */
public class MultiplyTwoInteger {

	public static int multiplyTwoInteger(int a, int b) {
		int small = a > b ? b : a;
		int big = a > b ? a : b;
		int count = 0;
		int result = 0;

		while (small > 0) {
			if ((small & 1) == 1)
				result += big << count;
			count++;
			small = small >> 1;
		}
		return result; // SHOULD CONSIDER INT OVERFLOW !!!
	}

	public static void main(String[] args) {
		System.out.println(multiplyTwoInteger(11, 3));
	}
}
