package com.leetcode_restart;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        helper(n, k, new ArrayList<>(), result, 1);
        return result;
    }

    private void helper(int n, int k, List<Integer> list, List<List<Integer>> result, int start) {


        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }


        for (int i = start; i <= n; i++) {
            list.add(i);
            helper(n, k, list, result, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
