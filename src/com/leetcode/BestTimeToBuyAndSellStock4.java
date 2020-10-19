package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class BestTimeToBuyAndSellStock4 {

    Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        new BestTimeToBuyAndSellStock4().maxProfit(2, new int[]{3, 3, 5, 0, 0, 3, 1, 4});
    }

    public int maxProfit(int k, int[] prices) {

        if (k >= prices.length / 2) return quickSolve(prices);
        return helper(prices, k, 0, false);
    }

    private int helper(int[] prices, int maxTransactions, int index, boolean isBuy) {

        if (index >= prices.length || maxTransactions == 0)
            return 0;

        String key = new StringBuilder().
                append(index).
                append("_").
                append(isBuy).
                append("_").
                append(maxTransactions).toString();

        if (map.containsKey(key)) {
            return map.get(key);
        }

        int max = 0;
        int maxSell = 0;
        int buyStock = 0;
        int doNothing = 0;
        int sellStock = 0;
        int doNothingSell = 0;
        if (!isBuy) {
            buyStock += helper(prices, maxTransactions, index + 1, true) - prices[index];
            doNothing += helper(prices, maxTransactions, index + 1, false);
            max = Math.max(buyStock, doNothing);
        } else {
            sellStock += helper(prices, maxTransactions - 1, index + 1, false) + prices[index];
            doNothingSell += helper(prices, maxTransactions, index + 1, true);
            max = Math.max(sellStock, doNothingSell);
        }

        //int maxOverall = Math.max(max, maxSell);

        map.put(key, max);

        return max;

    }

    private int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }
}
