package com.leetcode;

import java.util.HashMap;

public class BestTimeToBuyAndSellStock3 {
    HashMap<String, Integer> hm = new HashMap<>();

    public static void main(String[] args) {

        int result = new BestTimeToBuyAndSellStock3().maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4});
        System.out.println("result = " + result);
    }

    public int maxProfit(int[] prices) {


        return helper(0, 0, prices, true);
    }


    private int helper(int index, int maxTransactions, int[] prices, boolean isBuy) {

        if (index > prices.length - 1 || maxTransactions == 2) {
            return 0;
        }

        String key = new StringBuilder().append(index).append("kun").append(isBuy).append("aguero").append(maxTransactions).toString();
        if (hm.containsKey(key)) {
            return hm.get(key);
        }


        int maxProfit;
        if (isBuy) {

            int profitWhenStockBought = helper(index + 1, maxTransactions, prices, false) - prices[index];
            int profitWhenDoNothing = helper(index + 1, maxTransactions, prices, true);

            maxProfit = Math.max(profitWhenStockBought, profitWhenDoNothing);
        } else {

            int profitWhenStockSold = helper(index + 1, maxTransactions + 1, prices, true) + prices[index];
            int profitWhenDoNothingWhileSell = helper(index + 1, maxTransactions, prices, false);

            maxProfit = Math.max(profitWhenStockSold, profitWhenDoNothingWhileSell);
        }

        hm.put(key, maxProfit);

        return maxProfit;

    }
}
