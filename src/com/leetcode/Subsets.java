package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        new Subsets().subsets(new int[]{1, 2, 3});
    }


    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> resultList = new ArrayList<>();

        helper(resultList, new ArrayList<>(), nums, 0);


        return resultList;

    }

    private void helper(List<List<Integer>> resultList, List<Integer> tempList, int[] nums, int startIndex) {
        resultList.add(new ArrayList<>(tempList));

        for (int i = startIndex; i < nums.length; i++) {
            tempList.add(nums[i]);
            helper(resultList, tempList, nums, startIndex + 1);
            tempList.remove(tempList.size() - 1);
        }


    }
}
