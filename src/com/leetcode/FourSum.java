package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum {


    Set<List<Integer>> resultList = new HashSet<>();

    //[-3,-2,-1,0,0,1,2,3]
    //0
    public static void main(String[] args) {
        new FourSum().fourSum(new int[]{-3, -2, -1, 0, 0, 1, 2, 3}, 0);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        helper(nums, target, new ArrayList<>(), 0, 0, visited);
        return new ArrayList<>(resultList);
    }

    private void helper(int[] nums, int target, List<Integer> list, int index, int currSum, boolean[] visited) {


        if (list.size() == 4 && currSum != target) {
            return;
        }
        if (list.size() == 4 && currSum == target) {

            resultList.add(new ArrayList(list));
            return;
        }


        //[-3,-2,-1,0,0,1,2,3]
//0
        for (int i = index; i < nums.length; i++) {

            list.add(nums[i]);
            helper(nums, target, list, i + 1, currSum + nums[i], visited);
            list.remove(list.size() - 1);

        }


    }
}
