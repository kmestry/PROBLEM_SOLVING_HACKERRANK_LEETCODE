package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutations2OctChallenge {

    List<List<Integer>> resultList = new ArrayList<>();

    public static void main(String[] args) {
        List<List<Integer>> result = new Permutations2OctChallenge().permuteUnique(new int[]{1, 1, 2});
        System.out.println("result = " + result);
    }

    public List<List<Integer>> permuteUnique(int[] nums) {

        boolean[] visited = new boolean[nums.length];
        helper(nums, new ArrayList<>(), visited);
        return (resultList);

    }

    private void helper(int[] nums, List<Integer> list, boolean[] visited) {

        if (list.size() == nums.length) {
            resultList.add(new ArrayList<>(list));
            return;
        }


        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            list.add(nums[i]);
            visited[i] = true;
            helper(nums, list, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
        }


    }
}
