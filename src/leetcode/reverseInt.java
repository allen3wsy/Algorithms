package leetcode;


public class reverseInt {

	// reverse the int Using % and /
	public static int reverse(int x)   {	
		boolean positive = true;
	    if (x < 0){
	        positive = false;
	        x = -x;
	    }
	    
	    int result = 0;
	    while (x != 0){
	        int remainder = x % 10;
	        x = x / 10;
	        result = result * 10 + remainder;
	    }
	    
	    if (positive == false)  {
	        result = -1 * result;
	    }

	    return result;

	}
	
	public static void main(String[] args)	{
		System.out.println(reverse(-123));
	}
}


