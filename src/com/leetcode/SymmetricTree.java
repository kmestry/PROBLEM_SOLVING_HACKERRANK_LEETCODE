package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SymmetricTree {

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(2, null, new TreeNode(3, new TreeNode(5, new TreeNode(9), new TreeNode(8)), new TreeNode(4)));

        new SymmetricTree().isSymmetric(treeNode);
    }

    public boolean isSymmetric(TreeNode root) {


        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }

        TreeNode leftSubTree = root.left;
        TreeNode rightSubTree = root.right;

        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();
        createLeftTreeList(leftSubTree, leftList);
        createRightTreeList(rightSubTree, rightList);

        System.out.println("leftList = " + leftList);
        System.out.println("rightList = " + rightList);


        return leftList.equals(rightList);

    }

    private void createLeftTreeList(TreeNode treeNode, List<Integer> resultList) {

        if (treeNode == null) {
            resultList.add(-10);
            return;
        }

        resultList.add(treeNode.val);

        createLeftTreeList(treeNode.left, resultList);
        createLeftTreeList(treeNode.right, resultList);

    }

    private void createRightTreeList(TreeNode treeNode, List<Integer> resultList) {

        if (treeNode == null) {
            resultList.add(-10);
            return;
        }
        resultList.add(treeNode.val);

        createRightTreeList(treeNode.right, resultList);
        createRightTreeList(treeNode.left, resultList);

    }

}
