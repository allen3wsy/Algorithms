package dp;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock3 {

	// http://blog.csdn.net/fightforyourdream/article/details/14503469
	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0)
			return 0;

		int[] left = new int[prices.length];
		int[] right = new int[prices.length];

		// calculate the left[] and the right[]
		calculateMaxProfitDP(prices, left, right);

		// iterate through left[] and right[] to find the separation day with
		// max total profit
		int max = 0;
		for (int i = 0; i < prices.length; i++)
			max = Math.max(max, left[i] + right[i]); // add them up

		return max;
	}

	public static void calculateMaxProfitDP(int[] prices, int[] left,
			int[] right) {

		int min = prices[0]; // initialize the min, left[0] is still 0 (EX!!!)
		for (int i = 1; i < left.length; i++) { // from left[1] till the end
			left[i] = Math.max(left[i - 1], prices[i] - min); // update max diff
			min = Math.min(prices[i], min); // update min
		}

		int max = prices[prices.length - 1]; // initialize the max
		for (int i = right.length - 2; i >= 0; i--) { // [n - 2] to left end
			// right[N - 1] is still 0, // update max diff
			right[i] = Math.max(right[i + 1], max - prices[i]);
			max = Math.max(prices[i], max); // update max
		}

		System.out.println("left[] is: " + Arrays.toString(left));
		System.out.println("right[] is: " + Arrays.toString(right));
	}

	public static void main(String[] args) {

		int[] prices = { 2, 1, 2, 0, 4 };
		System.out.println(maxProfit(prices));
		System.out.println("Days are from [0, N - 1]");
		System.out.println("So 2 answers: day 2 and day 3: maxProfit is 5");
	}
}
