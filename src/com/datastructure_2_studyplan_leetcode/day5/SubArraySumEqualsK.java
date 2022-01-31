package com.datastructure_2_studyplan_leetcode.day5;

public class SubArraySumEqualsK {

    public int subarraySum(int[] nums, int k) {

        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            int currSum = 0;
            currSum += nums[i];
            if (currSum == k) result++;
            for (int j = i + 1; j < nums.length; j++) {
                currSum += nums[j];
                if (currSum == k) result++;
            }
        }

        return result;
    }
}
