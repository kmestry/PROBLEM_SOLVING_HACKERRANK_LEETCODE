package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {

    List<List<Integer>> resultList = new ArrayList<>();

    public static void main(String[] args) {
        new CombinationSum3().combinationSum3(3, 7);
    }

    public List<List<Integer>> combinationSum3(int k, int n) {


        helper(k, n, 0, new ArrayList<Integer>(), 1);
        return resultList;
    }


    private void helper(int numberOfElements, int targetSum, int sum, List<Integer> list, int index) {

        if (sum > targetSum) return;

        if (list.size() == numberOfElements && sum == targetSum) {
            resultList.add(new ArrayList<>(list));
        }

        for (int i = index; i < 10; i++) {

            if (list.contains(i)) continue;
            list.add(i);
            helper(numberOfElements, targetSum, sum + i, list, i + 1); // pass index to not include the various permutations of elements.
            list.remove(list.size() - 1);  //backtracking happens here.

        }
    }
}

