package others;

public class BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1)
            return 0;
        int min = Integer.MAX_VALUE;		// this will go down !!!
        int diff = 0;						// profit is at least 0, will go up
        
        // keep track of the min value 
        // and the difference
        for(int i = 0; i < prices.length; i++)  {
            min = Math.min(min, prices[i]);
            diff = Math.max(diff, prices[i] - min);
        }
        
        return diff;		// diff is the max profit
    }
    
    public static void main(String[] args) {
		int[] prices = {5, 1};
		System.out.println(maxProfit(prices));
	}
}
