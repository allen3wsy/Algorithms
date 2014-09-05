package others;

public class PlusOne {

	public static int[] plusOne(int[] digits) {

		int carry = 0;
		int i = digits.length - 1;
		digits[i] += 1;

		while(i >= 0) {
			if(carry == 1)  {
				digits[i] += 1;
				carry = 0;
			}
			if(digits[i] == 10) {  // overflow
				carry = 1;
				digits[i] = 0;
			}   else {
				return digits;
			}
			i--;   
		}

		if(carry == 1)	{
			int[] newDigits = new int[digits.length + 1];  
			System.arraycopy(digits, 0, newDigits, 1, digits.length);
			newDigits[0] = 1;  
			return newDigits;
		}

		return digits;
	}

	public static void main(String[] args)	{
		int[] digits = {9, 9};
		int[] result = plusOne(digits);
		System.out.println(result.length);		// length should be 3: {1, 0, 0}

		System.out.println(result[0]);
	}
}
