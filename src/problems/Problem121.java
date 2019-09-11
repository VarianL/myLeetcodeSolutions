package problems;

/**
 *  Best Time to Buy and Sell Stock
 */
public class Problem121 {

    public int maxProfit(int[] prices) {
        if(prices.length == 1 || prices.length == 0){
            return 0;
        }
        int max = prices[1] - prices[0];
        int min = Integer.MAX_VALUE;
        for (int var : prices) {
            if (var < min) {
                min = var;
            }
            max = max > (var - min) ? max : var - min;
        }
        return max;
    }
    
}