package com.datastructure_studyplan_leetcode;

public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {

        //find so far min

        int soFarMin = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > soFarMin) {
                max = Math.max(max, prices[i] - soFarMin);
            } else {
                soFarMin = prices[i];
            }
        }

        return max;

    }
}

