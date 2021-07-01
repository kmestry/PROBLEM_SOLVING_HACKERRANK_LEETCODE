package com.blind_list_75.array;

public class BestTimeToBuyAndSellStock {

    // Brute force approach.
    public int maxProfit(int[] prices) {

        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] >= prices[i]) {
                    maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
                }
            }
        }
        return maxProfit;
    }
}
