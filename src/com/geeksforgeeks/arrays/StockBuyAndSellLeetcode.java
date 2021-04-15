package com.geeksforgeeks.arrays;

public class StockBuyAndSellLeetcode {

    public static void main(String[] args) {
        StockBuyAndSellLeetcode stockBuyAndSellLeetcode = new StockBuyAndSellLeetcode();
        stockBuyAndSellLeetcode.maxProfit(new int[]{1, 2, 3, 4, 5});
    }

    public int maxProfit(int[] A) {


        int n = A.length;
        int maxProfit = 0;
        int lPointer = 0;
        int rPointer = 1;

        int buyIndex = 0;
        int sellIndex = 1;

        while (rPointer < n) {
            if (A[rPointer] > A[lPointer]) {
                sellIndex++;
            } else {
                maxProfit += addToProfit(buyIndex, sellIndex, A);
                lPointer = sellIndex;
                rPointer = lPointer + 1;

                buyIndex = lPointer;
                sellIndex = rPointer;
                continue;
            }
            rPointer++;
            lPointer++;

        }
        maxProfit += addToProfit(buyIndex, sellIndex, A);
        return maxProfit;
    }

    private int addToProfit(int buyIndex, int sellIndex, int[] prices) {
        if (sellIndex > buyIndex + 1) {
            return (prices[sellIndex - 1] - prices[buyIndex]);
        }
        return 0;
    }
}
