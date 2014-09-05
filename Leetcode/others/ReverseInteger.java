package others;

public class ReverseInteger {
	
	// explain :
    // http://fisherlei.blogspot.com/2012/12/leetcode-reverse-integer.html
    // http://www.programcreek.com/2012/12/leetcode-reverse-integer/
    public static int reverse(int x)   {
        
        //flag marks if x is negative
    	boolean flag = false;
    	if (x < 0) {
    		x = -x;
    		flag = true;
    	} 
    	
        int result = 0;  
        
        while(x > 0)  {
            result = result * 10 + x % 10;  
            // if I need to discuss with the interviewer about the overflow problem, then I need to 
            // check whether Math.abs(Integer.MAX_VALUE - result) is decreasing or not...
            x = x / 10;  
        }  
    
        return flag == true ? -result : result;  
    }
    
    public static void main(String[] args) {
		System.out.println(reverse(Integer.MAX_VALUE));  // OVERFLOW  already !!!
		System.out.println(Integer.MAX_VALUE);
		
		StringBuilder sb = new StringBuilder();
		
	}
}
