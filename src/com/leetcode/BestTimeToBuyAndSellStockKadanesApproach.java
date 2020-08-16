package com.leetcode;

public class BestTimeToBuyAndSellStockKadanesApproach {

    public static void main(String[] args) {
        //2 4 0
    }


    public int maxProfit(int[] prices) {

        if (prices.length == 0) return 0;
        int minTillNow = prices[0];
        int maxProfit = Integer.MIN_VALUE;


        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minTillNow) {
                minTillNow = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - minTillNow);
            }
        }

        return maxProfit;
    }
}
