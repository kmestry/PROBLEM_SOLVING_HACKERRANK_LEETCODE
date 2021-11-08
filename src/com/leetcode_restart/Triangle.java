package com.leetcode_restart;

import java.util.ArrayList;
import java.util.List;

public class Triangle {

    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();
        l1.add(-1);
        List<Integer> l2 = new ArrayList<>();
        l2.add(2);
        l2.add(3);
        List<Integer> l3 = new ArrayList<>();
        l3.add(1);
        l3.add(-1);
        l3.add(-3);

        // -1
        // 2  3

        //1 -1  -3

        List<List<Integer>> lists = new ArrayList<>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        int ans = new Triangle().minimumTotal(lists);
        System.out.println("ans = " + ans);
    }

    public int minimumTotal(List<List<Integer>> triangle) {

        return helper(triangle, 0, 0);
    }

    private int helper(List<List<Integer>> triangle, int listNum, int index) {

        if (listNum >= triangle.size()) return 0;
        if (index >= triangle.get(listNum).size()) return 0;

        int path1 = helper(triangle, listNum + 1, index);
        int path2 = helper(triangle, listNum + 1, index + 1);

        int min = Math.min(path1, path2) + triangle.get(listNum).get(index);

        return min;

    }
}
