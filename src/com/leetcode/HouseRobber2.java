package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class HouseRobber2 {

    Map<Integer, Integer> m1 = new HashMap<>();
    Map<Integer, Integer> m2 = new HashMap<>();

    public int rob(int[] nums) {

        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[] firstArray = new int[nums.length - 1];
        int[] secondArray = new int[nums.length - 1];


        for (int i = 0; i < nums.length - 1; i++) {
            firstArray[i] = nums[i];
        }

        for (int j = 1; j < nums.length; j++) {
            secondArray[j - 1] = nums[j];
        }

        int firstCase = helper1(firstArray, 0);
        int secondCase = helper2(secondArray, 0);

        int result = Math.max(firstCase, secondCase);

        return result;

    }


    //robbery done from house 1 to n-1
    private int helper1(int[] nums, int index) {

        if (index >= nums.length) return 0;

        if (m1.containsKey(index))
            return m1.get(index);

        int robberyDone = helper1(nums, index + 2) + nums[index]; //robbery done and add money
        int robberyNotDone = helper1(nums, index + 1); //robbery not done on currrent day so go to next day.


        int result = Math.max(robberyDone, robberyNotDone);

        m1.put(index, result);

        return result;
    }


    //robbery done from house 1 to n-1
    private int helper2(int[] nums, int index) {

        if (index >= nums.length) return 0;

        if (m2.containsKey(index))
            return m2.get(index);

        int robberyDone = helper2(nums, index + 2) + nums[index]; //robbery done and add money
        int robberyNotDone = helper2(nums, index + 1); //robbery not done on currrent day so go to next day.


        int result = Math.max(robberyDone, robberyNotDone);

        m2.put(index, result);

        return result;
    }
}
