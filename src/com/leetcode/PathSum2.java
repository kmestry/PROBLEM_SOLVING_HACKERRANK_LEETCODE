package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {

    List<List<Integer>> resultList = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3, new TreeNode(9, new TreeNode(10), new TreeNode(26)), new TreeNode(20, new TreeNode(15, null, null), new TreeNode(7, null, null)));
        List<List<Integer>> result = new PathSum2().pathSum(treeNode, 38);
        System.out.println("result = " + result);

     /*   TreeNode treeNode = new TreeNode();
        List<List<Integer>> result = new PathSum2().pathSum(treeNode, 1);
        System.out.println("result = " + result);*/
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        if (root == null)
            return null;

        dfsHelper(root, sum, 0, new ArrayList<>());

        return resultList;

    }

    private void dfsHelper(TreeNode node, int sum, int cumulativeSum, List<Integer> list) {


        if (node != null) {
            list.add(node.val);

            cumulativeSum += node.val;
        }

        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null && cumulativeSum == sum) {
            resultList.add(new ArrayList<>(list));
        }

        if (node.left != null) {
            dfsHelper(node.left, sum, cumulativeSum, list);
            list.remove(list.size() - 1);
        }

        if (node.right != null) {
            dfsHelper(node.right, sum, cumulativeSum, list);
            list.remove(list.size() - 1);
        }

    }
}
