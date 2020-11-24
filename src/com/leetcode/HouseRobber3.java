package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class HouseRobber3 {

    Map<TreeNode, Integer> dpMap = new HashMap<>();

    public static void main(String[] args) {
        // TreeNode treeNode = new TreeNode(3, new TreeNode(2, null, new TreeNode(3)), new TreeNode(3, null, new TreeNode(1)));

        TreeNode treeNode = new TreeNode(2, new TreeNode(1, null, new TreeNode(4)), new TreeNode(3));

        HouseRobber3 obj = new HouseRobber3();

        int result = obj.rob(treeNode);
    }

    public int rob(TreeNode root) {

        if (root == null) {
            return 0;
        }

   /*     if (dpMap.containsKey(root))
            return dpMap.get(root);*/

        int rob = 0;
        int noRob = 0;

        //case 1 : start
        // if we rob root we can rob its 1st grandchildrens
        if (root.left != null) {
            rob += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            rob += rob(root.right.left) + rob(root.right.right);
        }
        rob += root.val; // rob root
        //case 1 : end


        //case 2 : start
        //if we do not rob root we can rob its children
        noRob += rob(root.left) + rob(root.right);
        //case 2 : end

        int max = Math.max(rob, noRob);

        dpMap.put(root, max);

        return max;
    }
}
