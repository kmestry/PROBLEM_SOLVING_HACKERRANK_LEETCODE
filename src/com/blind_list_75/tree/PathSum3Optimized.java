package com.blind_list_75.tree;

import java.util.HashMap;
import java.util.Map;

public class PathSum3Optimized {
    int count = 0;

    public int pathSum(TreeNode root, int targetSum) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        helper(root, targetSum, 0, map);
        return count;
    }

    private void helper(TreeNode root, int targetSum, int currSum, Map<Integer, Integer> map) {

        if (root == null) return;
        currSum += root.val;


        if (map.containsKey(currSum - targetSum)) {
            count += map.get(currSum - targetSum);
        }

        if (map.containsKey(currSum)) {
            map.put(currSum, map.get(currSum) + 1);
        } else {
            map.put(currSum, 1);
        }

        helper(root.left, targetSum, currSum, map);
        helper(root.right, targetSum, currSum, map);

        map.put(currSum, map.get(currSum) - 1);
    }
}
