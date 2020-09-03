package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicates2 {


    Map<Integer, Integer> map = new HashMap<>();  // map with nums[i] as key and index as value.

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {

                int val = map.get(nums[i]);
                int diff = Math.abs(i - val);

                if (diff <= k) {
                    return true;
                } else {
                    map.put(nums[i], i);   // this is needed to override the element and the index when the diff <= k is false. eg : [1,0,1,1] k = 1
                }

            } else {
                map.put(nums[i], i);
            }
        }

        return false;
    }

}
