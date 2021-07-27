package com.blind_list_75.tree;

import java.util.ArrayList;
import java.util.List;

public class SubTreeOfAnotherTree {

    List<TreeNode> nodeList = new ArrayList<>();

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        findRoot(root, subRoot.val);

        for (TreeNode n : nodeList) {
            if (traverse(n, subRoot))
                return true;
        }

        return false;
    }

    private void findRoot(TreeNode root, int val) {

        if (root == null) {
            return;
        }

        if (root.val == val) {
            nodeList.add(root);
            //return;
        }
        findRoot(root.left, val);
        findRoot(root.right, val);
    }

    private boolean traverse(TreeNode root, TreeNode subRoot) {

        if (root == null && subRoot == null) {
            return true;
        } else if ((root == null && subRoot != null) || (subRoot == null && root != null)) {
            return false;
        }

        if (root.val == subRoot.val) {
            return traverse(root.left, subRoot.left) &&
                    traverse(root.right, subRoot.right);
        }

        return false;
    }
}
