package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class HouseRobber3 {

    int firstCase = 0;
    int secondCase = 0;
    Map<TreeNode, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3, new TreeNode(2, null, new TreeNode(3)), new TreeNode(3, null, new TreeNode(1)));

        HouseRobber3 obj = new HouseRobber3();

        int result = obj.rob(treeNode);
    }

    public int rob(TreeNode root) {

        if (root == null) return 0;

        //[4,1,null,2,null,3]
        if (map.containsKey(root)) {
            return map.get(root);
        }

        int value = 0;
        if (root.left != null) {
            value += rob(root.left.left) + rob(root.left.right);

        }
        if (root.right != null) {
            value += rob(root.right.left) + rob(root.right.right);
        }

        int result = Math.max(value + root.val, rob(root.left) + rob(root.right));

        map.put(root, result);

        return result;

    }
}
