package com.leetcode_march_22;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {

        Set<List<Integer>> res = new HashSet<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];

            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {
                int tot = curr + nums[l] + nums[r];
                if (tot == 0) {
                    List<Integer> list = Arrays.asList(curr, nums[l], nums[r]);
                    res.add(list);
                    l++;
                    r--;
                } else if (tot > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }

        return new ArrayList<>(res);

    }

}
