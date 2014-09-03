package leetcode;

public class JumpGame {

	// easiest solution !!!
	// http://blog.csdn.net/havenoidea/article/details/11852457
	public static boolean canJump(int A[]) {

		int length = A.length;
		int maxReach = 0;
		for (int i = 0; i < length; i++) {
			if (i > maxReach)
				return false;
			maxReach = Math.max(maxReach, i + A[i]);
		}
		return maxReach >= length - 1;
	}

	public static void main(String[] args) {

		int[] A = { 5, 4, 0, 0, 0, 0, 0 };
		System.out.println(canJump(A));
	}
}
