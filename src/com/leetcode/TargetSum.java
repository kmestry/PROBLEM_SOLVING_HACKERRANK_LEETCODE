package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {

    Map<String, Integer> map = new HashMap<>();

    public int findTargetSumWays(int[] nums, int S) {

        return helper(nums, S, 0, 0);

    }

    private int helper(int[] nums, int targetSum, int index, int sum) {

        //Base condition when sum == targetSum. we return 1
        //as we need to find the number of ways we can reach targetSum
        if (index == nums.length && sum == targetSum) {
            return 1;
        }
        //Base condition when sum != targetSum . we return 0 from here
        //as we do not want this case in final answer
        if (index == nums.length && sum != targetSum) {
            return 0;
        }

        //memoization using map.
        //used immutabality property of String for unique key in map.
        String key = sum + "()" + index;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        int count = 0;
        //first case we take negative value of current index
        count += helper(nums, targetSum, index + 1, sum - nums[index]);
        //second case we take positive value of current index
        count += helper(nums, targetSum, index + 1, sum + nums[index]);

        //add to map for future use.
        map.put(key, count);

        return count;

    }
}
