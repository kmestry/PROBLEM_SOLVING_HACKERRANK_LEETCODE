package com.hackerrank.algorithms.slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class MaximumElementSubArray {

  /*  Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
    Output: [3,3,5,5,6,7]*/

    public static void main(String[] args) {
        //maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);

        //maximumSumOfSubArrayInSlidingWindow(new int[]{1, 9, -1, -2, 7, 3, -1, 2}, 4);

        // maximumSumOfSubArrayInSlidingWindow(new int[]{3,2,6,-1,4,5,-1,2}, 4);
        maximumSumOfSubArrayInSlidingWindow(new int[]{1, 4, 2, 10, 2, 3, 1, 0, 20}, 4);

        //  maxSlidingWindow(new int[]{1}, 1);

    }


    public static int maximumSumOfSubArrayInSlidingWindow(int[] nums, int k) {

        int originalWindow = k;
        int maximumSumOfSubArray = 0;

        Integer initialSumOfWindow = Integer.valueOf(0);

        for (int i = 0; i < k; i++) {
            initialSumOfWindow += nums[i];

        }

        maximumSumOfSubArray = initialSumOfWindow;
        int nextSum = initialSumOfWindow;
        System.out.println("nextSum = " + nextSum);

        for (int i = 1; i <= nums.length - k; i++) {
            int sumOfSubArray = nextSum - nums[i - 1] + nums[originalWindow + i - 1];
            nextSum = sumOfSubArray;
            System.out.println("nextSum = " + nextSum);
            if (sumOfSubArray > maximumSumOfSubArray) {
                maximumSumOfSubArray = sumOfSubArray;
            }
        }


        System.out.println("maximumSumOfSubArray = " + maximumSumOfSubArray);
        return maximumSumOfSubArray;
    }


    public static int[] maxSlidingWindow(int[] nums, int k) {

        int originalWindow = k;
        List<Integer> result = new ArrayList<>();
        List<Integer> innerList = new ArrayList<>();
        int leftWindow = 0;


        while (k <= nums.length) {
            while (leftWindow <= nums.length - originalWindow) {
                for (int j = leftWindow; j < k; j++) {
                    innerList.add(nums[j]);
                }
                int maxSubArray = maximum(innerList);
                innerList.clear();
                result.add(maxSubArray);
                k++;
                leftWindow++;
                break;
            }


        }

        System.out.println("result = " + result);
        return result.stream().mapToInt(value -> value).toArray();
    }

    static int maximum(List<Integer> array) {
        return array.stream().max(Integer::compareTo).get();
    }
}
