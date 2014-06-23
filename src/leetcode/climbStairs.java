package leetcode;

public class climbStairs {
	
    public static int climbStairs(int n) 	{	      
    	int[] A = new int[n + 1];	   
    	return climbStairs(n, A); 
    }
	
    public static int climbStairs(int n, int[] A)  {
        if(n < 0)
            return 0;
        if(n == 0)
            return 1;
        if(n == 1)
            return 1;
        if(A[n] != 0)
            return A[n];
        else 
            A[n] = climbStairs(n - 1, A) + climbStairs(n - 2, A);
        return A[n];
    }
    
    public static void main(String[] args)	{
    	System.out.println(climbStairs(1));
    }
}
