package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum4 {

    List<List<Integer>> result = new ArrayList<>();


    //memory limit exceeded using extra memory List.
    public int combinationSum4(int[] nums, int target) {


        helper(nums, target, 0, new ArrayList<>());
        //stem.out.println(result);

        return result.size();
    }

    private void helper(int[] nums, int target, int sum, List<Integer> list) {

        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(list));

        }


        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
            helper(nums, target, sum + nums[i], list);
            list.remove(list.size() - 1);
        }

    }
}
