package com.leetcode;

public class SameTreeOptimized100 {

    public static void main(String[] args) {

        isSameTree(new TreeNode(1, new TreeNode(2), new TreeNode(3)), new TreeNode(1, new TreeNode(2), new TreeNode(3)));


    }


    public static boolean isSameTree(TreeNode p, TreeNode q) {


        if (p == null && q == null) return true;
        if (p == null || q == null) {
            if (p != q) {
                return false;
            }
        } else if (p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);


    }


}
