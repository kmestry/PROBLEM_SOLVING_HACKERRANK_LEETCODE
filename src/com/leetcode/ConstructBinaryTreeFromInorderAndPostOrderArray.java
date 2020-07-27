package com.leetcode;

import java.util.HashMap;

public class ConstructBinaryTreeFromInorderAndPostOrderArray {


    HashMap<Integer, Integer> map = null;
    int post_index = 0;

    public static void main(String[] args) {

        TreeNode result = new ConstructBinaryTreeFromInorderAndPostOrderArray().buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});


    }

    public TreeNode buildTree(int[] inorder, int[] post) {
        map = new HashMap<>();
        post_index = post.length - 1;

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return construct(post, 0, inorder.length - 1);
    }

    public TreeNode construct(int[] post, int instart, int inend) {
        if (instart > inend) return null;

        int index = map.get(post[post_index]);

        TreeNode root = new TreeNode(post[post_index]);

        post_index--;

        root.right = construct(post, index + 1, inend);
        root.left = construct(post, instart, index - 1);

        return root;

    }


}


