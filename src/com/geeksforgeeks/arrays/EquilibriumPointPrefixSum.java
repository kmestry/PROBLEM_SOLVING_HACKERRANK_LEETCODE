package com.geeksforgeeks.arrays;

public class EquilibriumPointPrefixSum {
    public static void main(String[] args) {

        EquilibriumPointPrefixSum equilibriumPointPrefixSum = new EquilibriumPointPrefixSum();
        long result = equilibriumPointPrefixSum.hasEquilibriumPoint(new long[]{3, 4, 8, -9, 20, 6});
        System.out.println("result = " + result);
        // 4 2 -2
        // 3 4 8 -9 20 6
    }

    private long hasEquilibriumPoint(long[] arr) {

        long totalSum = 0;

        for (long num : arr) {
            totalSum += num;
        }

        int leftSum = 0;

        for (long i = 0; i < arr.length; i++) {
            if (leftSum == totalSum - arr[(int) i]) {
                return i + 1; // as return is expected to be 1-indexed
            }
            totalSum -= arr[(int) i];
            leftSum += arr[(int) i];
        }

        return -1;
    }


}
