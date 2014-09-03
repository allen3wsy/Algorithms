package leetcode;

public class GasStation {

	// http://blog.csdn.net/fightforyourdream/article/details/16875259
	// O(n) DP
	public static int canCompleteCircuit(int[] gas, int[] cost) {
		int curSum = 0; // currently gas remained
		int total = 0; // total gas
		int startIndex = 0;

		for (int i = 0; i < gas.length; i++) {
			int diff = gas[i] - cost[i];
			if (curSum + diff >= 0) { // if gas left for right now, then go on
				curSum += diff;
			} else {
				curSum = 0;
				startIndex = i + 1; // otherwise, start from herre
			}
			total += diff; // boundary case: if the rightmost
		}

		return total >= 0 ? startIndex : -1;
	}
}
