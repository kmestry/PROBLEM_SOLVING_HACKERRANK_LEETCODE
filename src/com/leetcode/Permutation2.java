package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Permutation2 {

    List<List<Integer>> resultList = new ArrayList<>();

    public static void main(String[] args) {
        List<List<Integer>> list = new Permutation2().permuteUnique(new int[]{1, 1, 2, 1});
        System.out.println("list = " + list);
    }

    public List<List<Integer>> permuteUnique(int[] nums) {

        if (nums.length == 0) return Collections.emptyList();
        boolean[] isVisited = new boolean[nums.length];
        Arrays.sort(nums);
        backTrack(nums, new ArrayList<>(), isVisited);
        //System.out.println(resultList);
        return (resultList);


    }


    private void backTrack(int[] nums, List<Integer> currentList, boolean[] isVisited) {

        if (currentList.size() == nums.length) {
            resultList.add(new ArrayList<>(currentList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (isVisited[i]) continue;
            currentList.add(nums[i]);
            isVisited[i] = true;
            backTrack(nums, currentList, isVisited);
            currentList.remove(currentList.size() - 1);
            isVisited[i] = false;
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) i++;

        }
    }
}
