package com.blind_list_75.array;

import java.util.HashMap;
import java.util.Map;

public class BestTimeToBuyAndSellStock2 {

    Map<String, Integer> map = new HashMap<>();

    public int maxProfit(int[] prices) {

        return helper(prices, true, 0);

    }

    private int helper(int[] prices, boolean isBuy, int index) {

        if (index >= prices.length) {
            return 0;
        }
        String key = isBuy + ")" + index;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        int maxProfit;
        if (isBuy) {
            int profitWhenBuy = helper(prices, false, index + 1) - prices[index];
            int profitWhenNoBuy = helper(prices, true, index + 1);
            maxProfit = Math.max(profitWhenBuy, profitWhenNoBuy);
        } else {
            int profitWhenSell = helper(prices, true, index + 1) + prices[index];
            int profitWhenNoSell = helper(prices, false, index + 1);
            maxProfit = Math.max(profitWhenSell, profitWhenNoSell);
        }
        map.put(key, maxProfit);
        return maxProfit;
    }
}
