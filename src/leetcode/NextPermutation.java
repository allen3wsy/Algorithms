package leetcode;

public class NextPermutation {
	    
    // The solution could be explain by example, consider  7 5 8 6 2 1 ->  next is :  7 6 1 2 5 8, use your maths skills to find out !!

    // So the approach is: starting from the end, find the longest increasing sequence (8 6 2 1), swap the conflict number (5 here)        // which disturbs the increasing sequence with the smallest number (6 here) in the increasing sequence which is larger than this 
    // conflict number. Reverse the increasing sequence after the conflict number. If we cannot find such conflict number, it means the
    // whole sequence is increasing from right to left. Then the next one is the reversed one of the whole sequence. 
    //
    public static void nextPermutation(int[] num) {
        if(num == null || num.length == 0)
            return;
        int i = num.length - 2;                     // start from the end...
        while(i >= 0 && num[i] >= num[i + 1]) {     // increasing order (from end to front)
            i--;
        } // num[i] right now is either the conflict number or the first number
        // but since i >= 0: then num[i] must be the conflict number, otherwise i = -1 !!!!!!!!
        if(i >= 0)  {
            int j = i + 1;
            while(j < num.length && num[j] > num[i])    {
                j++;
            }
            j--;
            int temp = num[i];
            num[i] = num[j];
            num[j] = temp;
        }
        reverse(num, i + 1);
    }
    
    // pos is the left position to reverse, num.length is the right position to swap:
    public static void reverse(int[] num, int pos)   {
        int left = pos;
        int right = num.length - 1;
        
        while(left < right)    {
            int temp = num[left];
            num[left] = num[right];
            num[right] = temp;
            left++;
            right--;
        }
    }
    
    
    public static void main(String[] args)	{
    	int[] array = {7, 5, 8, 6, 2, 1};
    	
    	for(int i : array)	{
    		System.out.print(i + " ");
    	}
    	
    	System.out.println();
    	nextPermutation(array);
    	
    	for(int i : array)	{
    		System.out.print(i + " ");
    	}
    }
}
