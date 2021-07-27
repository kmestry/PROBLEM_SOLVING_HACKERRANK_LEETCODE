package com.blind_list_75.tree;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {

    List<List<Integer>> list = new ArrayList<>();

    public static void main(String[] args) {
        PathSum2 pathSum2 = new PathSum2();
        TreeNode node1 = new TreeNode(11,
                new TreeNode(7), new TreeNode(2));
        TreeNode node2 = new TreeNode(4, node1, null);

        //right
        TreeNode nodeR1 = new TreeNode(4,
                new TreeNode(5), new TreeNode(1));
        TreeNode nodeR2 = new TreeNode(8, new TreeNode(13), nodeR1);

        TreeNode root = new TreeNode(5, node2, nodeR2);
        pathSum2.pathSum(root, 22);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        helper(root, targetSum, 0, new ArrayList<>());
        return list;
    }


    private void helper(TreeNode root, int targetSum, int currSum, List<Integer> inList) {

        if (root == null) return;
        currSum += root.val;
        inList.add(root.val);

        if (root.left == null && root.right == null && currSum == targetSum) {
            list.add(new ArrayList<>(inList));
        }
        helper(root.left, targetSum, currSum, inList);
        helper(root.right, targetSum, currSum, inList);
        inList.remove(inList.size() - 1);


    }
}
