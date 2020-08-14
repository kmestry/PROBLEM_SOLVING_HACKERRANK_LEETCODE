package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2 {

    public static void main(String[] args) {
        new Subsets2().subsetsWithDup(new int[]{1, 2, 2});
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();

        Arrays.sort(nums);
        helper(resultList, new ArrayList<>(), nums, 0);

        return resultList;

    }

    private void helper(List<List<Integer>> resultList, List<Integer> tempList, int[] nums, int startIndex) {

        resultList.add(new ArrayList<>(tempList));

        for (int i = startIndex; i < nums.length; i++) {
            if (i > startIndex && nums[i] == nums[i - 1]) continue;
            tempList.add(nums[i]);
            helper(resultList, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }


    }
}
