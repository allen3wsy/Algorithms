package leetcode;

public class SingleNumber_2 {

	public static int findNum(int[] A)	{

        int result = 0;
        
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int j = 0; j < A.length; j++) {
                count += ((A[j] >> i) & 1); 	// for every bit 
            }
            result |= ((count % 3) << i);   // put the rest into result
        } 
		return result;
	}
	
	
	public static void main(String[] args)	{
		int[] array = {1, 2, 2, 3, 4, 5, 10};
		System.out.println(findNum(array));
	}
}
