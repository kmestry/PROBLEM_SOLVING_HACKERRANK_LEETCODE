package com.datastructure_studyplan_leetcode;

import java.util.HashSet;
import java.util.Set;

public class TwoSumBST {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return find(root, set, k);
    }

    private boolean find(TreeNode root, Set<Integer> seen, int k) {

        if (root == null) return false;

        if (seen.contains(root.val)) return true;
        seen.add(k - root.val);
        return find(root.left, seen, k) || find(root.right, seen, k);
    }
}
