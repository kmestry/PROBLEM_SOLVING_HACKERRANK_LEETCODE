package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

    List<List<Integer>> resultList = new ArrayList<>();

    public static void main(String[] args) {
        new CombinationSum2().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        boolean[] visited = new boolean[candidates.length];
        Arrays.sort(candidates);
        helper(candidates, target, new ArrayList<>(), 0, 0, visited);

        System.out.println("resultList== " + resultList);
        return resultList;
    }

    private void helper(int[] candidates, int target, List<Integer> list, int sum, int index, boolean[] visited) {

        if (sum > target) {
            return;
        }

        if (sum == target) {
            resultList.add(new ArrayList<>(list));
        }

        for (int i = index; i < candidates.length; i++) {

            if (visited[i]) continue;
            list.add(candidates[i]);
            visited[i] = true;
            helper(candidates, target, list, sum + candidates[i], i + 1, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }

    }
}
