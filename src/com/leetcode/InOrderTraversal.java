package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class InOrderTraversal {

    List<Integer> result = new ArrayList<>();

    public static void main(String[] args) {
        List<Integer> result = new InOrderTraversal().inorderTraversal(new TreeNode());
        System.out.println("result.size() = " + result.size());
    }

    public List<Integer> inorderTraversal(TreeNode root) {

        if (root == null) {
            return null;
        }
        inorderTraversal(root.left);
        result.add(root.val);
        System.out.println(root.val);
        inorderTraversal(root.right);

        return result;
    }
}
