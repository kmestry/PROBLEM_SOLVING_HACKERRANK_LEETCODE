package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3SeptChallenge {

    List<List<Integer>> resultList = new ArrayList<>();

    public static void main(String[] args) {
        List<List<Integer>> resultList = new CombinationSum3SeptChallenge().combinationSum3(3, 7);
        System.out.println("resultList = " + resultList);
    }

    public List<List<Integer>> combinationSum3(int k, int n) {

        helper(k, n, 0, new ArrayList<>(), 1);
        return resultList;
    }


    //add index to avoid permutations or duplicates [1,2,4] is same as[4,1,2]
    private void helper(int listSize, int target, int sum, List<Integer> list, int index) {

        if (sum > target) return;  //base condition

        if (list.size() == listSize && sum == target) {
            resultList.add(new ArrayList<>(list));
        }

        for (int i = index; i <= 9; i++) {

            if (list.contains(i)) continue;
            list.add(i);
            helper(listSize, target, sum + i, list, i);
            list.remove(list.size() - 1);  //backtracking magic
        }

    }
}
