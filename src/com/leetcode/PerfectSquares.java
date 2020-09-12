package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PerfectSquares {

    //using combination logic .. using extra space list.
    //backtracking.
    // results in TLE

    int minCount = Integer.MAX_VALUE;


    public int numSquares(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i * i <= n) {
                list.add(i * i);
            }
            if (i * i > n) {
                break;
            }

        }

        helper(list, 0, n, new ArrayList<>(), 0);

        return minCount;


    }

    private void helper(List<Integer> list, int sum, int target, List<Integer> helperList, int index) {

        if (sum > target) return;
        if (sum == target) {
            minCount = Math.min(minCount, helperList.size());
        }

        for (int i = index; i < list.size(); i++) {
            helperList.add(list.get(i));
            helper(list, sum + list.get(i), target, helperList, i);
            helperList.remove(helperList.size() - 1);
        }

    }
}
