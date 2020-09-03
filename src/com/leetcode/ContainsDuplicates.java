package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicates {


    Map<Integer, Integer> map = new HashMap<>();

    public boolean containsDuplicate(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return true;
            } else {
                map.put(nums[i], 1);
            }
        }

        return false;

    }

    public boolean containsDuplicateSetApproach(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
        }

        return false;
    }
}
