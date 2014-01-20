
public class cracking_5 {

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
		
		public static void main(String[] args) {
			int a = 15;
			int b = 1;
			int c = updateBits(a, b, 1, 6);  // 5 - 1 should be big enough
			System.out.println("a should be 15: " + a);
			System.out.println("b should be 1: " + b);
			System.out.println("c shoud be 31: " + c);
		}
}
