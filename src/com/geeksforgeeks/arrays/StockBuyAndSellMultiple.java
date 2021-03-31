package com.geeksforgeeks.arrays;

import java.util.HashMap;
import java.util.Map;

public class StockBuyAndSellMultiple {
    Map<String, Integer> memoMap = new HashMap<>();

    public static void main(String[] args) {
        StockBuyAndSellMultiple stockBuyAndSellMultiple = new StockBuyAndSellMultiple();
        stockBuyAndSellMultiple.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
    }

    public int maxProfit(int[] prices) {
        return helper(prices, 0, true);

    }

    // 2 choices on a day: buy stock or do nothing or sell stock or do nothing
    private int helper(int[] prices, int index, boolean isBuy) {
        int maxProfit = 0;
        if (index >= prices.length) return maxProfit;

        String key = index + "_" + isBuy;
        if (memoMap.containsKey(key))
            return memoMap.get(key);

        if (isBuy) {
            int maxProfitWhenBuy = helper(prices, index + 1, false) - prices[index];
            int maxProfitWhenDoNothing = helper(prices, index + 1, true);
            maxProfit = Math.max(maxProfitWhenBuy, maxProfitWhenDoNothing);
        } else {
            int maxProfitWhenSell = helper(prices, index + 1, true) + prices[index];
            int maxProfitSellWhenDoNothing = helper(prices, index + 1, false);
            maxProfit = Math.max(maxProfitWhenSell, maxProfitSellWhenDoNothing);
        }
        memoMap.put(key, maxProfit);
        return maxProfit;
    }
}
