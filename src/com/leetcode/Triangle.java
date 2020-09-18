package com.leetcode;

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

        List<List<Integer>> lists = new ArrayList<>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        int ans = new Triangle().minimumTotal(lists);
        System.out.println("ans = " + ans);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        Integer[][] dp = new Integer[triangle.size()][triangle.size()];
        return helper(triangle, 0, 0, dp);
    }

    public int helper(List<List<Integer>> triangle, int offset, int listNum, Integer[][] dp) {
        if (listNum >= triangle.size()) {
            return 0;
        }
        if (dp[listNum][offset] != null)
            return dp[listNum][offset];  // listNum is the list in the triangle list. and offset is the element selected from the list.
        List<Integer> list = triangle.get(listNum);
        int pick1 = helper(triangle, offset, listNum + 1, dp);// pick first element of every list as offset is 0.
        int pick2 = helper(triangle, offset + 1, listNum + 1, dp);//pick elements from the list apart from index 0 elements.
        int ans = Math.min(pick1, pick2) + list.get(offset); // find minimum of both picks. and add the list element to the minimum
        dp[listNum][offset] = ans;
        return ans;
    }
}
