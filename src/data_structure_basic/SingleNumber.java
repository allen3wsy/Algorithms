package data_structure_basic;

/* The advanced class of this is not solved yet.
 * 
 * */
public class SingleNumber {
	
	// other numbers should be number counts
	public static int singleNumber() {
        int [] arr = {4,4,5,5,6,6,2,3,2,3,3,3,10};
		int i,xor,len = arr.length;

        for(xor = 0,i = 0; i < len ; i++)
            xor = xor ^ arr[i];

        return xor; 
	}
	
	
	public static void main(String[] args)	{
		System.out.println(singleNumber());
		
	}
  

}
