package com.leetcode_restart;


public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {

        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            int currMax = Integer.MIN_VALUE;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] > prices[i]) {
                    currMax = Math.max(currMax, prices[j] - prices[i]);
                }
            }
            maxProfit = Math.max(maxProfit, currMax);
        }

        return maxProfit;
    }

}
