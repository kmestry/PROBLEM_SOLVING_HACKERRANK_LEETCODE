package com.blind_list_75;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        // 2,0 ,, 7,1 ,, 11,2 ,, 15,3

        // 3,1
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            // System.out.println(num);
            if (map.containsKey(target - num) && map.get(target - num) != i) {
                result[0] = i;
                result[1] = map.get(target - num);
                return result;
            }
        }

        return new int[2];
    }
}
