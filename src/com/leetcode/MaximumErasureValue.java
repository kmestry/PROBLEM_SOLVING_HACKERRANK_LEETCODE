package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class MaximumErasureValue {

    public static void main(String[] args) {
        new MaximumErasureValue().maximumUniqueSubarray(new int[]{4, 2, 4, 5, 6});
    }

    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();

        int left = 0;
        int right = 0;
        int maxSum = Integer.MIN_VALUE;
        int sumTillNow = 0;

        while (right < nums.length) {

            int val = nums[right];

            if (!set.contains(val)) {
                set.add(val);
                sumTillNow += val;
                right++;
            } else {
                int valLeft = nums[left];
                set.remove(nums[left]);
                left++;
                maxSum = Math.max(sumTillNow, maxSum);
                sumTillNow -= valLeft;
            }

        }

        maxSum = Math.max(sumTillNow, maxSum);

        return maxSum;
    }
}
