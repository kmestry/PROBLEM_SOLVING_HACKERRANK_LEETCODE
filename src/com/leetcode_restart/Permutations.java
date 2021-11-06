package com.leetcode_restart;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        helper(new ArrayList<>(), nums, 0, visited);
        return result;

    }

    private void helper(List<Integer> list, int[] nums, int start, boolean[] visited) {

        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            list.add(nums[i]);
            visited[i] = true;
            // System.out.println("== " + list);
            helper(list, nums, start + 1, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }

    }
}
