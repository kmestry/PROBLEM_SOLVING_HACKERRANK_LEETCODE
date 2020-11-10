package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeTilt {

    List<Integer> list = new ArrayList<>();
    int sum = 0;

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3, new TreeNode(2, null, new TreeNode(3)), new TreeNode(3, null, new TreeNode(1)));
        new BinaryTreeTilt().findTilt(treeNode);
    }

    public int findTilt(TreeNode root) {
        helper(root);
        return sum;
    }

    private void helper(TreeNode root) {

        if (root == null) {
            list.add(0);
            return;
        }
        helper(root.left);

        helper(root.right);
        list.add(root.val);

        int diff = Math.abs(list.get(0) - list.get(1));
        sum += diff;
        list.clear();


    }
}
