
public class Cracking_17 {
	
	/**
	 * 17.1
	 * @param a
	 * @param b
	 */
	public static void swap(int a, int b) {
		// Example for a = 9, b = 4
		a = a - b; // a = 9 - 4 = 5
		b = a + b; // b = 5 + 4 = 9
		a = b - a; // a = 9 - 5
		
		System.out.println("a: " + a);
		System.out.println("b: " + b);
	}
	
	
	/**
	 * 17.1
	 * Note: The XOR operation is a 3-nary relation: (a, b, c can be XOR to reach each other....) 
	 * XOR is like a transitive relationship...
	 * 
	 * This function can be used to perform not just Integer...
	 * @param a
	 * @param b
	 */
	public static void swap_opt(int a, int b) {		// a = 0; b = 1
		a = a ^ b; 		// after: a = 1 : a is the diff right now
		b = a ^ b; 		// after: b = 0	: diff ^ b should be a
		a = a ^ b; 		// after: a = 1 : diff ^ a should be b
		
		System.out.println("a: " + a);
		System.out.println("b: " + b);
	}
	
	/**
	 * 17.2
	 * 
	 * @param args
	 */
	
	public static void main(String[] args) {
		// 17.1
		int a = 1672;
		int b = 9332;
		
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		
		swap(a, b);
		swap_opt(a, b);
		
		// 17.2
	}
}
