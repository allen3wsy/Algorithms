package others;

public class FindTheCelebrity {

	public boolean knows(int a, int b) {
		return false;
	}

	/**
	 * http://www.cnblogs.com/grandyang/p/5310649.html
	 */
	public int findCelebrity(int n) {
		if (n <= 1)
			return -1;

		int celebrity = 0; // assume the celebrity is 0

		// first pass: find the only possible celebrity 
		for (int i = 0; i < n; i++) {
			if (knows(celebrity, i)) {
				celebrity = i;
			}
		}

		// second pass: validate if the celebrity is the right or not
		for (int i = 0; i < n; i++) {
			if (i != celebrity && (!knows(i, celebrity) || knows(celebrity, i))) {
				return -1;
			}
		}
		return celebrity;
	}
}
