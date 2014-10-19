package dp;

public class ClimbingStairs {

    public static int climbStairs(int n) {
        if(n < 0) return 0;
        int[] A = new int[n + 1];
        return climbStairs(n, A); 
    }
    
    public static int climbStairs(int n, int[] A)  {
        if(n == 0 || n == 1)  //  if (n == 1):  also return 1........
            return 1;
        if(A[n] != 0)       // here is why we should use DP
            return A[n];
        else 
            A[n] = climbStairs(n - 1, A) + climbStairs(n - 2, A);
        return A[n];
    }
	
	public static void main(String[] args) {
		System.out.println(climbStairs(1));
	}
}
