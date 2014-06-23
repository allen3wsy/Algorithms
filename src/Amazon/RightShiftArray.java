package Amazon;


public class RightShiftArray {

	public static void right_shift(int[] arr, int n)	{
		int length = arr.length;
		
		int i = 0;
		int j = length - 1;
		shift(arr, i, j);
		
		int digit = n % length; // the digtis to be shifted right
		
		// left part
		i = 0;
		j = digit - 1;	
		shift(arr, i, j);
		
		// right part
		i = digit;
		j = length - 1;
		shift(arr, i, j);
		
	}
	
	public static void shift(int[] arr, int i, int j)	{
		while(i < j)	{
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
	}
	
	public static void main(String[] args)	{
		int[] arr = {1, 2, 3, 4};
		
		right_shift(arr, 5);
		
		// print result
		for(int i : arr)	{
			System.out.println(i);
		}
	}
}
