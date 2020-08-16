package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class BestTimeToBuyAndSellStock {


    Map<String, Integer> memoizeMap = new HashMap<>();

    public static void main(String[] args) {
        int result = new BestTimeToBuyAndSellStock().maxProfitOptimized(new int[]{2, 4, 1});
        System.out.println("result = " + result);
    }

    public int maxProfit(int[] prices) {

        if (prices.length == 0) return 0;

        int maxProfit = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {

                int profit = prices[j] - prices[i];
                if (profit > maxProfit) {
                    maxProfit = profit;
                }

            }
        }

        return maxProfit < 0 ? 0 : maxProfit;
    }

    public int maxProfitOptimized(int[] prices) {

        return helper(0, 0, true, prices);

    }

    private int helper(int maxTransactions, int index, boolean isBuy, int[] prices) {

        if (index > prices.length - 1 || maxTransactions == 1) {
            return 0;
        }

        String key = index + "profit" + isBuy + "sum" + maxTransactions;
        if (memoizeMap.containsKey(key)) {
            return memoizeMap.get(key);
        }
        int maxProfit;

        if (isBuy) {

            int profitWhenBuy = helper(maxTransactions, index + 1, false, prices) - prices[index];
            int profitWhenDoNothing = helper(maxTransactions, index + 1, true, prices);

            maxProfit = Math.max(profitWhenBuy, profitWhenDoNothing);
        } else {

            int profitWhenSell = helper(maxTransactions + 1, index + 1, true, prices) + prices[index];
            int profitWhenDoNothing = helper(maxTransactions, index + 1, false, prices);

            maxProfit = Math.max(profitWhenDoNothing, profitWhenSell);
        }

        memoizeMap.put(key, maxProfit);
        return maxProfit;

    }
}
