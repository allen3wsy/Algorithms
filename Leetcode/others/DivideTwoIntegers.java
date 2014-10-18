package others;

public class DivideTwoIntegers {

    // HAVE TO LOOK AT EXPLANATIONS !!!!!!!!
    // http://wp.javayu.me/2014/02/divide-two-integers/
    // USE CODE:
    // http://blog.csdn.net/linhuanmars/article/details/20024907
    // Dividend / Divisor !!!
    public static int divide(int dividend, int divisor) {
        if(divisor == 0)  
            return Integer.MAX_VALUE;  
        
        boolean isNeg = false;
        if((dividend > 0) != (divisor > 0))
            isNeg = true;
        int res = 0;
        
        /**
         * this snippet of code is not that necessary if we use long to cast dividend and divisor
         */
//        if(dividend == Integer.MIN_VALUE)  {
//            res = 1;  
//            dividend += Math.abs(divisor);  		 
//        }  
//        if(divisor == Integer.MIN_VALUE)  
//            return res;  
        /**
         * this snippet of code is not that necessary if we use long to cast dividend and divisor
         */
        // if we didn't use the above snippet, then we MUST use LONG
        long l_dividend = dividend;
        long l_divisor = divisor;
        
        // both get absulote values !!!
        l_dividend = Math.abs(l_dividend);  
        l_divisor = Math.abs(l_divisor); 
         
        int digit = 0;  
        
        // 23 / 3  ->  (23 / 12) :  digit = 2   result = 7    
        // 8 / 3  ->  (8 / 6)       digit = 1   result = 2
        // 8 / 9  ->  (8 / 9)       digit = 0   result = 0
        // be careful about the while condition: SHOULDN'T BE (l_dividend >= l_divisor)
        while(l_dividend >= (l_divisor << 1)) {
            l_divisor <<= 1;  
            digit++;  
        }  
        
        // digit == 1
        while(digit >= 0)  {
            if(l_dividend >= l_divisor)  {
                l_dividend -= l_divisor;    // 8 - 6 = 2
                res += (1 << digit);      	// res += 2^2, then 2^1, then 2^0 : log(N)
            }  
            l_divisor >>= 1;              // divisor = 3, then divisor = 1
            digit--;  
        }
        
        return isNeg ? -res : res;  
    }

	public static void main(String[] args) {
		// this should be error input !!!
//		System.out.println(divide(Integer.MIN_VALUE, -1));
		
		/**
		 * 3 important test cases !!!
		 */
		System.out.println(divide(8, 9));
		System.out.println(divide(8, 3));
		System.out.println(divide(23, 3));

		// Math.abs() on this value will never work !!!
		System.out.println("Absolute value? " + Math.abs(Integer.MIN_VALUE));

		/**
		 * try >>> and >>
		 */
		System.out.println(Integer.MAX_VALUE >> 1);		// fill "0"
		System.out.println(Integer.MAX_VALUE >>> 1);	// always fill "0"
		
		System.out.println(Integer.MIN_VALUE >> 1);		// fill "1"
		System.out.println(Integer.MIN_VALUE >>> 1);	// always fill "0"
		
		System.out.println((Integer.MAX_VALUE - 1) << 1); // can't do left-shift again !!!
	}
}
