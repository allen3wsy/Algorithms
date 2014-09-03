package algo_Midlevel;

public class MaxBinaryGap {
	public static int solution(int N) {
		int max = 0;
		int count = 0;				// after the rightmost 1 is met, count will be >= 0 forever
		int r = 0;

		boolean startFlag = false;  // will not be set to true until the rightmost 1 is fetched...
									// otherwise it will not start counting++ !!!!!!

		while (N > 0) {
			r = N & 1;	// get right most bit
			N = N >> 1;	// shift N 1 bit to right side

			if (0 == r && startFlag) 	// only when startFlag is true, we can start counting
				count++;

			if (1 == r) {				// if no 1 is met, we will not do this...
				max = count > max ? count : max;	
				startFlag = true;
				count = 0;
			}
		}

		return max;
	}

	public static void main(String[] args) {
		System.out.println(solution(8));	// 1000
		System.out.println(solution(9));	// 1001
		System.out.println(solution(10));	// 1010
		System.out.println(solution(11));	// 1011
		System.out.println(solution(12));	// 1100
	}
}
