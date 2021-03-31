package com.geeksforgeeks.arrays;

public class StockBuyAndSellMultipleOptimizedPeakValleyApproach {

    private int findMaxProfit(int[] arr) {

        int maxProfit = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                maxProfit += arr[i] - arr[i - 1];
            }
        }
        return maxProfit;
    }
}
