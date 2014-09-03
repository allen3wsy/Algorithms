package leetcode;

public class FirstMissingPositive {

	// REMEMBER THIS SOLUTION: swap numbers in place
    // http://www.cnblogs.com/AnnieKim/archive/2013/04/21/3034631.html
    
    // consider this case : [99, 1, 2], result should be 3
    // Also consider case: [3, 1, 2]  will swap twice when i = 0, until A[i] cannot be swapped
    public static int firstMissingPositive(int[] A) {
        for (int i = 0; i < A.length; i++)  {
        	// range should be [1, n] because we only consider positive numbers !!!
        	while (A[i] != i + 1 && A[i] > 0 && A[i] <= A.length && A[A[i] - 1] != A[i]) {
        		int temp = A[i];
        		A[i] = A[A[i] - 1];
        		A[temp - 1] = temp;
        	}
        }
        
        for (int i = 0; i < A.length; i++) { 
        	if (A[i] != i + 1) {     // check each one to see what is the first missing number!!!
        		return i + 1;
        	}
        }
        return A.length + 1;    // when all the numbers are placed RIGHT !!!
    }
}
