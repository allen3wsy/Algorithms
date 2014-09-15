package interviewFLGT;

import java.util.HashSet;
import java.util.Set;

public class Factorial {

	public static Set<Integer> findAllFactorial(int num) {
		Set<Integer> set = new HashSet<Integer>();
		// error check
		if (num <= 0)
			return set;

		for (int i = 1; i <= num; i++) {
			/* num is dividable by i */
			if (num % i == 0) {
				if (set.contains(i)) {
					return set;
				} else {
					set.add(i);
					set.add(num / i);
				}
			}
		}
		return set;
	}

	public static void main(String[] args) {
		int num = 48;
		System.out.println(findAllFactorial(48));
	}
}
