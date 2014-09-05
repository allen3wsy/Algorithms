package BSTGraph;

public class UniqueBinarySearchTree {

	// DP solution 
    public int numTrees(int n) {
        int[] A = new int[n + 1];
        return numTrees(n, A);
    }
	
	// for example: A[4] = A[0] * A[3] + A[1] * A[2] + A[2] * A[1] + A[3] * A[0]
    public static int numTrees(int n, int[] A)  {
        if(n < 0)
            return 0;
        if(n == 0)
            return 1;
        if(n == 1)
            return 1;
        if(A[n] != 0)
            return A[n];
        else {     	
        	for(int i = 0; i < n; i++)	{
        		A[n] += numTrees(i, A) * numTrees(n - i - 1, A);
        	}
        }    
        return A[n];
    }
	
}
