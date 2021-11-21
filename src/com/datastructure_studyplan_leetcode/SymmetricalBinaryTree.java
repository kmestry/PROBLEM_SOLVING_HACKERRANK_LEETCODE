package com.datastructure_studyplan_leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricalBinaryTree {

    public boolean isSymmetric(TreeNode root) {

        if (root == null || (root.left == null && root.right == null)) return true;

        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode left, TreeNode right) {

        Queue<TreeNode> leftQ = new LinkedList<>();
        Queue<TreeNode> rightQ = new LinkedList<>();

        leftQ.offer(left);
        rightQ.offer(right);

        while (!leftQ.isEmpty() && !rightQ.isEmpty()) {

            if (leftQ.size() != rightQ.size()) return false;

            int size = leftQ.size();

            for (int i = 0; i < size; i++) {
                TreeNode leftN = leftQ.poll();
                TreeNode rightN = rightQ.poll();

                if (leftN == null && rightN != null) return false;
                if (rightN == null && leftN != null) return false;
                if (leftN == null && rightN == null) continue;
                if (leftN.val != rightN.val) return false;


                leftQ.offer(leftN.left);


                leftQ.offer(leftN.right);


                rightQ.offer(rightN.right);


                rightQ.offer(rightN.left);
            }
        }
        return true;
    }
}
