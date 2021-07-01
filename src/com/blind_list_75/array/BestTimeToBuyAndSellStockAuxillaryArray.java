package com.blind_list_75.array;

public class BestTimeToBuyAndSellStockAuxillaryArray {

    // 2 4 1
    // 4 4 1
    public int maxProfit(int[] prices) {

        int maxProfit = 0;
        int[] aux = new int[prices.length];

        aux[aux.length - 1] = prices[prices.length - 1];

        for (int i = aux.length - 2; i >= 0; i--) {
            aux[i] = Math.max(prices[i], aux[i + 1]);
        }

        for (int i = 0; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, aux[i] - prices[i]);
        }

        return maxProfit;
    }

}

