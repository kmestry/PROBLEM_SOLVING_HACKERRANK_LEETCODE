package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    List<List<Integer>> resultList = new ArrayList<>();

    public static void main(String[] args) {
        List<List<Integer>> resultList = new CombinationSum().combinationSum(new int[]{2, 3, 6, 7}, 7);
        System.out.println("-1-3 = " + (5 + 4 - 3 - 2));

        // System.out.println("resultList = " + resultList);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {


        helper(candidates, target, 0, 0, new ArrayList<>());

        return resultList;

    }

    private void helper(int[] candidates, int target, int index, int sum, List<Integer> list) {

        if (sum > target) return;

        if (sum == target) {

            resultList.add(new ArrayList(list));
        }

        for (int i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            helper(candidates, target, i, sum + candidates[i], list);
            list.remove(list.size() - 1);

        }
    }

    private void helperApproach2(int[] candidates, int target, int index, int sum, List<Integer> list) {

        if (index >= candidates.length) return;
        if (sum > target) return;

        if (sum == target) {
            resultList.add(new ArrayList<>(list));
            return;
        }

        int val = candidates[index];
        list.add(val);
        helperApproach2(candidates, target, index, sum + candidates[index], list);
        list.remove(list.size() - 1);
        helperApproach2(candidates, target, index + 1, sum, list);
    }

}
