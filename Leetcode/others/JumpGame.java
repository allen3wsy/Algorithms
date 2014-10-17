package others;

public class JumpGame {

	// easiest solution !!!
	// http://blog.csdn.net/havenoidea/article/details/11852457
	public static boolean canJump(int A[]) {

		int size = A.length;
		int maxReach = 0;
		for (int i = 0; i < size; i++) {
			if (i > maxReach)
				return false;
			maxReach = Math.max(maxReach, i + A[i]);
		}
		return maxReach >= size - 1;
	}

	public static void main(String[] args) {

		int[] A = { 5, 4, 0, 0, 0, 0, 0 };
		System.out.println(canJump(A));
		
		float val = 2.2384f;
		System.out.printf("%.2f", val);
	}
}
