package Amazon;

// DONE!

public class findGreatestSum {

	public static void findGreatestSum()	{
//		Scanner s = new Scanner(System.in);
//		String[] arrstr = s.nextLine().split(" ");
//		int[] arr = new int[arrstr.length];
//		for(int i=0; i<arr.length; i++){
//			arr[i]=Integer.parseInt(arrstr[i]);
//			//System.out.println(arr[i]);
//		}
		int[] arr = {1, -2, 3, 10, -4, 7, 2, -5};
		int max = 0;
		int currMax = 0;
		int start = 0, end = 0;
		for(int i = 0; i < arr.length; i++) {
			currMax += arr[i];
			if(currMax < 0)	{         //no contribution to latter sub arr
				currMax = 0;
				start = i + 1;
			}
			if(currMax > max){
				max = currMax;
				end = i;
			}
		}
		
		if(max == 0) {   //	if all elements are negative
			max = arr[0];
			for(int i = 0; i < arr.length; i++)	{
				if(max < arr[i])	{
					max = arr[i];
					start = end = i;
				}
			}
		}
		
		System.out.println("The max sum is " + max + " position:" + start + "," + end);
	}
	
	public static void main(String[] args)	{
		findGreatestSum();
	}
}
