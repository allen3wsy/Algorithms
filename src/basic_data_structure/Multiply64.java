package basic_data_structure;
import java.math.BigInteger;

public class Multiply64 {

	public static BigInteger multiply64(long a, long b) {

		int a1 = (int) a;
		int a2 = (int) (a >> 32); // left part
		int b1 = (int) b;
		int b2 = (int) (b >> 32); // left part

		// BigInteger a2b2SS = (BigInteger) (multiply64(a2, b2)) << 64;
		long part1 = multiply32(a1, b1);
		long part2 = multiply32(a1, b2) + multiply32(a2, b1);
		long part3 = multiply32(a2, b2);

		BigInteger result = null;
		// result = (BigInteger) part1 + ((BigInteger) part2) << 32 + ((BigInteger) part3) << 64;
		return result;
	}

	public static long multiply32(int a, int b) {
		long result = 0;
		result = (long) a * (long) b;
		return result;
	}

	public static void main(String[] args) {
		System.out.println(multiply32(10, 11));
	}
}
