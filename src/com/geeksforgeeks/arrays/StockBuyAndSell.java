package com.geeksforgeeks.arrays;

import java.util.ArrayList;

public class StockBuyAndSell {

    public static void main(String[] args) {

        StockBuyAndSell stockBuyAndSell = new StockBuyAndSell();
        //stockBuyAndSell.stockBuySell(new int[]{100, 180, 260, 310, 40, 535, 695}, 7);
        stockBuyAndSell.stockBuySell(new int[]{4, 2, 2, 2, 4}, 5);

    }

    ArrayList<ArrayList<Integer>> stockBuySell(int[] A, int n) {
        // code here

        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();


        int lPointer = 0;
        int rPointer = 1;

        int buyIndex = 0;
        int sellIndex = 1;

        while (rPointer < n) {
            if (A[rPointer] > A[lPointer]) {
                sellIndex++;
            } else {
                addToList(resultList, buyIndex, sellIndex);
                lPointer = sellIndex;
                rPointer = lPointer + 1;

                buyIndex = lPointer;
                sellIndex = rPointer;
                continue;
            }
            rPointer++;
            lPointer++;

        }
        addToList(resultList, buyIndex, sellIndex);
        return resultList;
    }

    private void addToList(ArrayList<ArrayList<Integer>> resultList, int buyIndex, int sellIndex) {
        ArrayList<Integer> list = new ArrayList<>();
        if (sellIndex > buyIndex + 1) {
            list.add(buyIndex);
            list.add(sellIndex - 1);
            resultList.add(list);
        }
    }
}
