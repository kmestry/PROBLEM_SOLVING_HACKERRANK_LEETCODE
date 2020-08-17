package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class BestTimeToBuyAndSellStock2 {

    Map<String, Integer> memoizeMap = new HashMap<>();

    public static void main(String[] args) {
        int result = new BestTimeToBuyAndSellStock2().maxProfitRecursive(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println("result = " + result);

    }

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

    public int maxProfitRecursive(int[] prices) {

        return helper(0, prices, true);
    }

    private int helper(int index, int[] prices, boolean isBuy) {

        int maxProfit = 0;
        if (index > prices.length - 1)
            return maxProfit;

        String key = index + "leetcode" + isBuy;
        if (memoizeMap.containsKey(key))
            return memoizeMap.get(key);

        if (isBuy) {
            int profitWhenBuy = helper(index + 1, prices, false) - prices[index]; // reduce price when buy
            int profitWhenDoNothing = helper(index + 1, prices, true);
            maxProfit = Math.max(profitWhenBuy, profitWhenDoNothing);
        } else {
            int profitWhenSell = helper(index + 1, prices, true) + prices[index]; // increase price when sell..
            int profitWhenNotSell = helper(index + 1, prices, false);
            maxProfit = Math.max(profitWhenSell, profitWhenNotSell);
        }

        memoizeMap.put(key, maxProfit);

        return maxProfit;

    }
}
