package com.leetcode;

public class BestTimeStockBuySellCoolDown {

    public static void main(String[] args) {
        int result = new BestTimeStockBuySellCoolDown().maxProfit(new int[]{1, 2, 3, 0, 2});
    }

    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        //As you saw in the idea, we need to first compute the values for first 2 days
        if (prices.length == 2)
            return prices[0] > prices[1] ? 0 : prices[1] - prices[0];  // as we know we need max profit.
        //cannot use approach of Buy and sell if length is 2. it will lead to loss. so return 0.

        int[][] dp = new int[prices.length][2];
        //Evaluating the values for the first 2 days
        dp[0][0] = 0;
        dp[0][1] = -prices[0];    //If we buy on first day, we need to pay the prices
        dp[1][0] = Math.max(dp[0][1] + prices[1], dp[0][0]);
        dp[1][1] = Math.max(dp[0][0] - prices[1], dp[0][1]);


        for (int i = 2; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 2][0] - prices[i], dp[i - 1][1]);
        }
        return dp[prices.length - 1][0];
    }
}
