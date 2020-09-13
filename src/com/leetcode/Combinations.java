package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    List<List<Integer>> resultList = new ArrayList<>();

    public static void main(String[] args) {
        new Combinations().combine(4, 2);
    }

    public List<List<Integer>> combine(int n, int k) {

        helper(n, k, new ArrayList<>(), 1);
        return resultList;

    }

    private void helper(int limit, int targetSize, List<Integer> list, int index) {

        if (list.size() == targetSize) {
            resultList.add(new ArrayList<>(list));
            return;
        }


        for (int i = index; i <= limit; i++) {
            list.add(i);
            helper(limit, targetSize, list, i + 1);
            list.remove(list.size() - 1);
        }

    }
}
