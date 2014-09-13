package others;

public class Pow_X_N_ {

	public double power(double x, int n) {
		if (n == 0) // n == 0: base case
			return 1;
		if (n == 1)
			return x;

		double temp = power(x, n / 2); // (1 / 2) == 0 which means it // will go to
									// the base case: (n == 0), return 1
		if (n % 2 == 0) {
			return temp * temp;
		} else {
			return temp * temp * x;
		}
	}

	public double pow(double x, int n) {
		if (n < 0) {
			return 1 / power(x, -n);
		} else { // when n >= 0
			return power(x, n);
		}
	}
}
