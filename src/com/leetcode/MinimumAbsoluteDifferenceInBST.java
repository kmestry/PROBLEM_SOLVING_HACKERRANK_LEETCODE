package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MinimumAbsoluteDifferenceInBST {

    //BRUTE force solution.
    List<Integer> list = new ArrayList<>();

    public int getMinimumDifference(TreeNode root) {

        helper(root);
        //System.out.println(list);

        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                int diff = Math.abs(list.get(i) - list.get(j));
                minDiff = Math.min(diff, minDiff);
            }
        }


        return minDiff;

    }

    private void helper(TreeNode root) {

        if (root == null) return;
        helper(root.left);
        list.add(root.val);
        helper(root.right);
    }

}
