package leetcode;

public class JumpGame2 {

	// easy solution
	// http://coderuo.blogspot.com/2013/05/leetcode-jump-game-ii-in-java.html
	// We will add one step to our result and start next range when we go out of current range.

	// BUG FOUND !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! (test cases are not enough)
	// EX: even if the number is 0 or negative number, you can jump 1 step..
	// During interview, we can first use Jump Game 1 to test whether canJump(), if "yes",
	// then use this greedy algorithm to find the minimum steps to jump to end !!!
	public static int jump(int[] A) {
		int curMax = 0;
		int nextMax = 0;
		int steps = 0;
		
		for(int i = 0; i < A.length; i++) {
			if(i > curMax) {			// only when i exceeds curMax will steps++
				curMax = nextMax;
				steps++;
			}
			nextMax = Math.max(nextMax, A[i] + i);	// update every time!!!
		}
		return steps;
	}

	/**
	 * by Yuhan
	 * @param A
	 * @return
	 */
    public static int jumpHaha(int[] A) {
        int N = A.length;
        int curReach = 0;
        int nextReach = 0;
        int i = 0;
        int cnt = 0;
        while (i < N) {
            if (curReach >= N-1) 
            	return cnt;
            while (i < N && i <= curReach) {
            	nextReach = Math.max(nextReach, i+A[i]);
            	i++;
            }
            curReach = nextReach;
            cnt++;
        }
        return cnt;
    }
	
	public static void main(String[] args) {
		int[] A = { 2, 0, 0, 1, 4 };		// even if the number is 0, you can jump 1 step
		System.out.println(jump(A));
		
		int[] B = { 0, 0, 0, 1, 4 };		// even if the number is 0, you can jump 1 step
		System.out.println(jump(B));
		
		int[] C = { 2, 3, 1, 1, 4 };
		System.out.println(jump(C));
		
		int[] D = { 2, 6, 1, 1, 4, 1, 1 };
		System.out.println(jump(D));
		
		
	}

}
