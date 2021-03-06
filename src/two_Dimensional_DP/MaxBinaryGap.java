package two_Dimensional_DP;

// http://www.programcreek.com/2013/02/twitter-codility-problem-max-binary-gap/
public class MaxBinaryGap {
	public static int solution(int N) {
		int max = 0;
		int count = 0; // after the rightmost 1 is met, count will be >= 0
		int r = 0;

		// will not be set to true until the rightmost 1 is fetched...
		// otherwise it will not start counting++ !!!!!!
		boolean startFlag = false;

		while (N != 0) {
			r = N & 1; // get right most bit
			N = N >>> 1; // shift N 1 bit to right side

			// only when startFlag is true, we can start counting
			if (0 == r && startFlag)
				count++;

			if (1 == r) { // if no 1 is met, we will not do this...
				max = count > max ? count : max;
				startFlag = true;
				count = 0;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(Integer.toBinaryString(Integer.MIN_VALUE + 1));
		System.out.println(Integer.toBinaryString(Integer.MAX_VALUE + 2));
		System.out.println(solution(Integer.MAX_VALUE + 2)); // 30
		
		System.out.println(solution(9)); // 1001
		System.out.println(solution(10)); // 1010
		System.out.println(solution(11)); // 1011
		System.out.println(solution(12)); // 1100
	}
}
