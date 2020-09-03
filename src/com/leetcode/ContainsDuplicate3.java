package com.leetcode;

import java.util.TreeSet;

public class ContainsDuplicate3 {

    public static void main(String[] args) {
        new ContainsDuplicate3().containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0);
    }


    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 0) {
            return false;
        }

        // sliding window
        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            // abs difference
            // |nums[i] - nums[j]| <= t

            // if nums[j] <= nums[i] then:
            // nums[i] - t <= nums[j]

            // if nums[j] >= nums[i] then:
            // nums[j] <= t + nums[i]

            // which is:
            // nums[i] - t <= nums[j] <= t + nums[i]

            // basically, is there anything in the range [num - t, num + t]?

            if (!set.subSet((long) nums[i] - t, true, (long) nums[i] + t, true).isEmpty()) {
                return true;
            }

            set.add((long) nums[i]);
            if (set.size() > k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;


    }

}
