package com.geeksforgeeks.arrays;

public class PrefixSumFindRangeSum {
    public static void main(String[] args) {
        // 2 8 3 9 6 5 4
        PrefixSumFindRangeSum prefixSumFindRangeSum = new PrefixSumFindRangeSum();
        int[] arr = new int[]{2, 8, 3, 9, 6, 5, 4};
        int result = prefixSumFindRangeSum.getRangeSum(2, 6, arr);
        System.out.println("result = " + result);
    }

    private int getRangeSum(int left, int right, int[] array) {
        //find prefix sum;

        int currSum = array[0];
        for (int i = 1; i < array.length; i++) {
            currSum += array[i];
            array[i] = currSum;
        }

        if (left == 0) {
            return array[right];
        }

        return array[right] - array[left - 1];


    }
}

