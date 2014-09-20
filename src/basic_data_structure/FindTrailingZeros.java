package basic_data_structure;

public class FindTrailingZeros {

	public static int findTrailingZeros(int number) {

		int count = 0;

		if (number < 0) {
			System.out.println("Error: no Factorial for a number less than 0");
			return -1; // error condition
		}

		if (number == 5)
			return 1;
		
		while(number / 5 >= 1) {
			count += number / 5;
			number /= 5;
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(findTrailingZeros(24));
		System.out.println(findTrailingZeros(25));	// 5
		System.out.println(findTrailingZeros(125));
	}
}
