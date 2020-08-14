package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        new Permutations().permute(new int[]{1, 2, 3});
    }

    //[1,2,3]
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private void backtrack(List<List<Integer>> resultList, ArrayList<Integer> tempSet, int[] nums) {

        if (tempSet.size() == nums.length) {
            resultList.add(new ArrayList<>(tempSet));
            return;
        }


        for (int i = 0; i < nums.length; i++) {

            if (tempSet.contains(nums[i])) continue;
            tempSet.add(nums[i]);
            backtrack(resultList, tempSet, nums);
            tempSet.remove(tempSet.size() - 1);

        }

    }




















/*
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) continue; // element already exists, skip
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }*/
}
