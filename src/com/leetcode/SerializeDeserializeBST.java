package com.leetcode;

public class SerializeDeserializeBST {

    // Encodes a tree to a single string.
    StringBuilder sb = new StringBuilder();

    public String serialize(TreeNode root) {

        if (root == null) return null;

        helper(root);
        return sb.toString();
    }

    private void helper(TreeNode root) {

        if (root == null) return;
        sb.append(root.val + " ");
        helper(root.left);
        helper(root.right);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if (data == null) return null;
        data = data.trim();
        String[] chars = data.split(" ");

        TreeNode node = createNode(chars, 0, chars.length - 1);

        return node;
    }

    private TreeNode createNode(String[] chars, int low, int high) {

        if (low > high) return null;
        System.out.println(chars[low]);
        TreeNode root = new TreeNode(Integer.parseInt(chars[low]));

        int index = findDivideIndex(chars, root.val, low + 1, high);

        root.left = createNode(chars, low + 1, index - 1);
        root.right = createNode(chars, index, high);


        return root;
    }

    private int findDivideIndex(String[] chars, int rootValue, int low, int high) {


        int i;
        for (i = low; i <= high; i++) {
            int val = Integer.parseInt(chars[i]);
            if (val > rootValue) {

                break;
            }

        }

        return i;
    }
}
