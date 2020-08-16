package com.leetcode;

public class BestTimeToBuyAndSellStock2 {

    public int maxProfit(int[] prices) {

        if (prices.length == 0) return 0;

        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - prices[i - 1];
            if (profit > 0) {
                maxProfit += profit;
            }
        }

        return maxProfit;

    }
}
