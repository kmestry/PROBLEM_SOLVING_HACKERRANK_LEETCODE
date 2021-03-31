package com.geeksforgeeks.arrays;

public class KadanesAlgorithm {

    public static void main(String[] args) {

        KadanesAlgorithm kadanesAlgorithm = new KadanesAlgorithm();
        int result = kadanesAlgorithm.maximumSubArraySum(new int[]{52, -81, 8, -47, -10});
        System.out.println("result = " + result);

    }

    private int maximumSubArraySum(int[] array) {
        int maxTillNow = array[0];

        int res = array[0];
        for (int i = 1; i < array.length; i++) {


            maxTillNow = Math.max(maxTillNow + array[i], array[i]);
            res = Math.max(res, maxTillNow);
        }

        return res;
    }
}
