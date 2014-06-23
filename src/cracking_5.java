import com.sun.org.apache.bcel.internal.generic.RETURN;


public class cracking_5 {
	
	/**
	 * 5.1
	 */
	public static int updateBits(int m, int n, int i, int j)	{
		// Validation
		if (i >= 32 || j <= i)	{
			return 0;
		}
		
		// clear n
		int allOne = -1;
		int left = allOne << (j + 1);
		int right = (1 << i) - 1;
		int mask = left | right;
		int n_cleared = n & mask; // Clear bits j through i.
		
		// shift m
		int m_shifted = m << i; // Move m into correct position.
		
		// merge them
		return n_cleared | m_shifted;
		
	}
	
	/**
	 * 5.2
	 */
	public static String printBinary(double num)	{
		if(num <= 0 || num >= 1) 
			return "ERROR";
		
		StringBuilder sb = new StringBuilder();
		sb.append(".");
		
		while(num > 0)	{
			if(sb.length() >= 32)	{	// setting a limit on length: 32 characters	
				return "ERROR";
			}
			
			double r = num * 2;
			if(r >= 1)	{
				sb.append(1);
				num = r - 1;
			} else {
				sb.append(0);
				num = r;
			}
		}
		
		return sb.toString();
	}
	
	/**
	 * 5.3
	 */
	
	// not yet... 
	
	/**
	 * 5.4
	 */
	// (n & (n - 1) ) == 0
	// means n is the power of 2
	
	/**
	 * 5.5
	 */
	public static int numToFlip(int a, int b)	{
		int c = a ^ b;
		int count = 0;
		while(c != 0)	{
//				if( (c & 1) != 0)
//					count++;
//				c >>>= 1;
			count++;
			c = c & (c - 1);
		}
		return count;
	}
	
	/**
	 * 5.6
	 * @param n
	 * @return
	 */
	
	// note: use only one | for OR(bit manipulation) !!!
	
	public static int swapAdvanced(int n){
		return ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);
	}
	
	/**
	 * 5.7 
	 */
	// not yet...
	
	/**
	 * 5.8
	 */
	// not yet...	
	
	public static void main(String[] args) {
		int a = 15;
		int b = 1;
		int c = updateBits(a, b, 1, 6);  // 5 - 1 should be big enough
		System.out.println("a should be 15: " + a);
		System.out.println("b should be 1: " + b);
		System.out.println("c shoud be 31: " + c);
	}
}
