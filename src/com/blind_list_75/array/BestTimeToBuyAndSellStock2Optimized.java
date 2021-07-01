package com.blind_list_75.array;

public class BestTimeToBuyAndSellStock2Optimized {

    public int maxProfit(int[] prices) {
        //peak valley approach

        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }

        return maxProfit;
    }
}
