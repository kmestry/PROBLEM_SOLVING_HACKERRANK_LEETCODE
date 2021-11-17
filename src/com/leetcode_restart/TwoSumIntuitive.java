package com.leetcode_restart;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumIntuitive {


    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];

        int index = 0;
        for (int num : nums) {
            if (map.containsKey(num)) {
                if (num + num == target) {
                    result[0] = map.get(num);
                    result[1] = index;
                    return result;
                }
            }
            map.put(num, index);
            index++;
        }
        //System.out.println(map);

        Arrays.sort(nums);

        int l = 0;
        int r = nums.length - 1;

        while (l < r) {

            if (nums[l] + nums[r] == target) {
                result[0] = map.get(nums[l]);
                result[1] = map.get(nums[r]);
                break;
            } else if (nums[l] + nums[r] > target) {
                r--;
            } else {
                l++;
            }

        }
        return result;

    }

}
