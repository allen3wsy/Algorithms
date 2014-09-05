package others;

public class Sqrt_X {

	public int sqrt(int x) {
		if (x < 0)
			return -1;

		// in case of x == 1
		long high = x / 2 + 1; // high should be long
		long low = 0; // low should be long

		while (low <= high) {
			long mid = (low + high) / 2; // mid should also be long

			long sq = mid * mid; // sq should also be long

			if (sq == (long) x) { // EX: overflow, Don't forget to cast
				return (int) mid; // cast
			} else if (sq < (long) x) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return (int) high; // right now: high < low, should always return high
	}
}
