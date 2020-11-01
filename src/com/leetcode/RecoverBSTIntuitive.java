package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class RecoverBSTIntuitive {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(3, null, new TreeNode(2)), null);
        new RecoverBSTIntuitive().recoverTree(root);
    }

    public void recoverTree(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        inOrder(root, list);

        // 321
        Integer first = null;
        Integer second = null;

        Integer prev = list.get(0);
        for (int i = 1; i < list.size(); i++) {


            if (prev > list.get(i) && first == null) {
                first = prev;
            }
            if (prev > list.get(i) && first != null) {
                second = list.get(i);
            }

            prev = list.get(i);

        }

        searchAndUpdate(root, first, second);


    }

    private void searchAndUpdate(TreeNode root, int value1, int value2) {

        if (root == null) {
            return;
        }
        searchAndUpdate(root.left, value1, value2);

        if (root.val == value1) {
            root.val = value2;
        } else if (root.val == value2) {
            root.val = value1;
        }

        searchAndUpdate(root.right, value1, value2);
    }

    private void inOrder(TreeNode treeNode, List<Integer> list) {

        if (treeNode == null) {
            return;
        }

        inOrder(treeNode.left, list);
        list.add(treeNode.val);
        inOrder(treeNode.right, list);

    }
}
