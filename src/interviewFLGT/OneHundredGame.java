package interviewFLGT;

public class OneHundredGame {

	public static boolean canIWin(int maxChoosableInteger, int desiredTotal) {

		boolean[] pool = new boolean[maxChoosableInteger];

		for (int i = 0; i < maxChoosableInteger; i++) {
			pool[i] = true;
			if (canP1Win(i + 1, desiredTotal, pool, true))
				return true;
			pool[i] = false;
		}
		return false;
	}

	// Overall heuristics : canP1Win is a method that tells us whether by making
	// this move p1 will win.
	// and we assume both p1 and p2 are extremely smart and therefore wil l
	// choose an optimal move to maximize their chances to win.

	// If the above statement is true, then the following is true:
	// 1. if p1 can find a way to win she will choose it
	// 2. if p2 can find a way to make p1 loose, she will choose it
	// Therefore in order for p1 to win, such way must not exist.

	private static boolean canP1Win(int currentSum, int total, boolean[] pool,
			boolean isLastP1) {

		// base case : someone did the final move, if it's p1 then she wins,
		// otherwise she looses.
		// System.out.println("curSum :"+currentSum+" total:"+total+" isP1:"+isLastP1);

		if (currentSum >= total)
			return isLastP1;

		// recursion : game continues
		boolean isCurrentPlayerP1 = !isLastP1;
		for (int i = 0; i < pool.length; i++) {

			if (pool[i])
				continue;

			pool[i] = true;
			boolean p1CanWin = canP1Win(currentSum + (i + 1), total, pool,
					isCurrentPlayerP1);

			pool[i] = false;

			// 1. if p1 can find a way to win she will choose it
			if (isCurrentPlayerP1 && p1CanWin)
				return true;
			// 2. if p2 can find a way to make p1 loose, she will choose it
			// Therefore in order for p1 to win, such way must not exist.
			else if (!isCurrentPlayerP1 && !p1CanWin) 
				return false;
			// two more possibilities

		}
		// player at this round has tried all possible moves:
		// 1.if it's p1's turn and she couldn't find any way to win, then she
		// looses
		// 2.if it's p2's turn and she couldn't find any way to make p1 loose,
		// p1 wins.
		return isCurrentPlayerP1 ? false : true;
	}

	public static void main(String[] args) {
		System.out.println(canIWin(3, 5));
	}
}
