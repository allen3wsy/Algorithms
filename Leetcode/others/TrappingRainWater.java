package others;

public class TrappingRainWater {

	// http://blog.csdn.net/fightforyourdream/article/details/15026089
    // DP: 2 O(N) array: left[] right[]
    public int trap(int[] A) {
        if(A.length == 0 || A == null) 
            return 0;  
          
        // calculate left[] and right[] using DP first 
        // left[]: from left to this one(i), higheset bar (including i)  
        // right[]: from right to this one(i), higheset bar (including i)  
        int[] left = new int[A.length];  
        int[] right = new int[A.length];  
          
        left[0] = A[0];         // should be itself
        for(int i = 1; i <= A.length - 1; i++) {  
            left[i] = Math.max(left[i - 1], A[i]);
        }  
        
        right[A.length - 1] = A[A.length - 1];  // should be itself
        for(int i = A.length - 2; i >= 0; i--)  {  
            right[i] = Math.max(right[i + 1], A[i]);  
        }  
          
        int sum = 0;
        for(int i = 1; i < A.length - 1; i++) {        // NOTICE: i from [1, n - 2]
            sum += Math.min(left[i], right[i]) - A[i];   // Math.min(left[i], right[i]) always >= A[i]
        }  
          
        return sum;  
    }
}
